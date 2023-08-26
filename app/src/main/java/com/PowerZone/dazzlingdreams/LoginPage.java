package com.PowerZone.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dazzlingdreams.R;

import java.util.Objects;
public class LoginPage extends AppCompatActivity {
    Button createaccount,Loginbtn;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login_page );

        Objects.requireNonNull( getSupportActionBar( ) ).setTitle( "Login Page");

        createaccount = findViewById(R.id.create_one);
        createaccount.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent(LoginPage.this,RegisterActivity.class) );
            }
        } );


        Loginbtn = findViewById(R.id.login);
        Loginbtn.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent(LoginPage.this,MainActivity.class) );
            }
        } );
    }
}