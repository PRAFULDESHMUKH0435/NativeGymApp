package com.PowerZone.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dazzlingdreams.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        getSupportActionBar().setTitle("Register Page");
    }
}