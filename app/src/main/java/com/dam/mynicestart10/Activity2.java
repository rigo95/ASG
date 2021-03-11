package com.dam.mynicestart10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

public class Activity2 extends AppCompatActivity {


    ImageView cara1;
    Button btnMain;
    ImageView imageView2;
    private SwipeRefreshLayout swipeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        imageView2 = findViewById(R.id.imageView2);
        registerForContextMenu(imageView2);
        cara1 = findViewById(R.id.imageView2);
        btnMain = findViewById(R.id.button4);

        Glide.with(this)
                .load(R.drawable.cara)
                .centerCrop()
                .circleCrop()
                .into(cara1);
    }


    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

            //    opción TOAST
            //
            //          Toast toast0 = Toast.makeText(MainContextActivity.this, "going swipeREFRESH", Toast.LENGTH_LONG);
            //          toast0.show();


            //   opción SNACKBAR

//           SUSTITUIR POR CONSTRAINT EN SU CASO
             final ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.activity_main_context);
//            final RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.activity_main_context);

            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            swipeLayout.setRefreshing(false);

        }
    };
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.edit:
                Toast toast = Toast.makeText(this, "editing avatar", Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.delete:
                Toast toast2 = Toast.makeText(this, "deleting avatar", Toast.LENGTH_LONG);
                toast2.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.camera) {
            Toast toast = Toast.makeText(this,"going APPBAR CAMERA",Toast.LENGTH_LONG );
            toast.show();
        }
        return super.onOptionsItemSelected(item);
    }

    // * DIALOGO MODAL *
    public void showAlertDialogButtonClicked(Activity2 view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.modal_dialog, null));

        builder.setPositiveButton("Glide", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }
        });

        builder.setNegativeButton("ChatBot", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("MotionLayout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void acceder2(View view) {
        Intent i = new Intent(this,Activity3.class);
        startActivity(i);
    }
}