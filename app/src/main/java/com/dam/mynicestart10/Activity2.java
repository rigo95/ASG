package com.dam.mynicestart10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Activity2 extends AppCompatActivity {

    ImageView cara1;
    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        cara1 = findViewById(R.id.imageView2);
        btnMain = findViewById(R.id.button4);
        Glide.with(this)
                .load(R.drawable.cara)
                .centerCrop()
                .circleCrop()
                .into(cara1);


    }

    public void acceder2(View view) {
        Intent i = new Intent(this,Activity3.class);
        startActivity(i);
    }
}