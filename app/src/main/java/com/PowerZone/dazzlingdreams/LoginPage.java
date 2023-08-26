package com.PowerZone.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dazzlingdreams.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;
public class LoginPage extends AppCompatActivity {
    Button createaccount,Loginbtn;
    FirebaseUser auth;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login_page );

        ///////////////////////
        auth = FirebaseAuth.getInstance().getCurrentUser();

        //////////////////////


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