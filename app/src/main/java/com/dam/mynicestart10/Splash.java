package com.dam.mynicestart10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    ImageView mySubtitle;
    TextView mySubtitle1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        mySubtitle= findViewById(R.id.cubo1);
        mySubtitle1 =findViewById(R.id.nombreApp);

        openApp(true);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mySubtitle.startAnimation(myanim);

        Animation myanim1 = AnimationUtils.loadAnimation(this, R.anim.move);
        mySubtitle.startAnimation(myanim);


    }

    private void openApp(boolean locationPermission){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, (5000));

    }



}
