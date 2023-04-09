package com.example.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddAttendence extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.single_attendence );

        getSupportActionBar().setTitle("Add Attendance");
    }
}