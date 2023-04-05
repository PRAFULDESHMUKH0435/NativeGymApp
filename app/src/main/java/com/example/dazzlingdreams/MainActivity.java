package com.example.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;

public class MainActivity extends AppCompatActivity {

    ImageSlider imageSlider;
    LinearLayout AddMember,ShowMember,AddAttendence,ContactUs;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        imageSlider = findViewById(R.id.image_slider);

        AddMember  = findViewById(R.id.add_member);
        AddMember.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( MainActivity.this, com.example.dazzlingdreams.AddMember.class ) );
            }
        } );


        ShowMember  = findViewById(R.id.show_members);
        ShowMember.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( MainActivity.this,ShowMembers.class) );
            }
        } );


        AddAttendence  = findViewById(R.id.add_attendence);
        AddMember.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( MainActivity.this, com.example.dazzlingdreams.AddMember.class ) );
            }
        } );

        ContactUs  = findViewById(R.id.contact_us);
        AddMember.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( MainActivity.this, com.example.dazzlingdreams.AddMember.class ) );
            }
        } );



    }
}