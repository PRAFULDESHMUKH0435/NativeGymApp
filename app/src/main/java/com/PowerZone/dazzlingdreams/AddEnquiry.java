package com.PowerZone.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AddEnquiry extends AppCompatActivity {

    FloatingActionButton fab ;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_attendence );

        getSupportActionBar().setTitle("Add Attendance");

        fab=findViewById(R.id.floatingActionButton);
        fab.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( AddEnquiry.this,AddInfo.class ) );
            }
        } );
    }
}