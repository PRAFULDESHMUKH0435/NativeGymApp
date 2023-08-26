package com.PowerZone.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.dazzlingdreams.R;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash_screen );
        getSupportActionBar().hide();


        Thread thread = new Thread(){
            public void run(){
                try {
                  sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent i = new Intent(Splash_Screen.this,LoginPage.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        thread.start();
    }
}