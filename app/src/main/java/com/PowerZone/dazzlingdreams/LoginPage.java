package com.PowerZone.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        auth = FirebaseAuth.getInstance().getCurrentUser();
        Objects.requireNonNull( getSupportActionBar( ) ).setTitle( "Login Page");

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Loginbtn = findViewById(R.id.login);
        Loginbtn.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                if (username.getText().toString().isEmpty()){
                    username.setError("Required");
                }else if (password.getText().toString().isEmpty()){
                    password.setError("Required");
                }else {
                    if (username.getText().toString().equals("test") && password.getText().toString().equals("test")){
                        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("userID", "yourUserID"); // Replace "yourUserID" with the actual user ID
//                editor.putString("password", "yourPassword"); // Replace "yourPassword" with the actual password
//                editor.apply();
                        startActivity( new Intent(LoginPage.this,MainActivity.class) );
                    }else {
                        Toast.makeText(LoginPage.this, "Invalid Username Or Password", Toast.LENGTH_SHORT).show();
                    }
                }

//                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("userID", "yourUserID"); // Replace "yourUserID" with the actual user ID
//                editor.putString("password", "yourPassword"); // Replace "yourPassword" with the actual password
//                editor.apply();


            }
        } );
    }
}