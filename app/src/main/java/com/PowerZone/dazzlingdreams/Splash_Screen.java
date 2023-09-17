package com.PowerZone.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

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
//                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                    String userid = sharedPreferences.getString("userID", "default");
//                    String password = sharedPreferences.getString("password", "default"); // 0 is the default value
//                    if (userid.equals("test") && password.equals("test")){
//                        Intent i = new Intent(Splash_Screen.this,MainActivity.class);
//                        startActivity(i);
//                        finish();
//                    }else {
//                        Intent i = new Intent(Splash_Screen.this,LoginPage.class);
//                        startActivity(i);
//                        finish();
//                    }
                }
            }
        };
        thread.start();
    }
}