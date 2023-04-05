package com.example.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;

public class MainActivity extends AppCompatActivity {

    ImageSlider imageSlider;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        imageSlider = findViewById(R.id.image_slider);

    }
}