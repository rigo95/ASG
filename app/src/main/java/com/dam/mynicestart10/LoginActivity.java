package com.dam.mynicestart10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button2= findViewById(R.id.button2);
    }


    public void Registro(View view) {
        Intent i = new Intent(this,Formulario.class);
        startActivity(i);
    }

    public void acceder(View view) {
        Intent i = new Intent(this,Activity2.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);


        startActivity(i);
    }
}