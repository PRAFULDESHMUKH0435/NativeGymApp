package com.example.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.snackbar.Snackbar;

import rezwan.pstu.cse12.youtubeonlinestatus.recievers.NetworkChangeReceiver;

public class MainActivity extends AppCompatActivity {

    ImageSlider imageSlider;
    LinearLayout AddMember,ShowMember,AddAttendence,ContactUs;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        NetworkChangeReceiver r = new NetworkChangeReceiver( this);
        r.build();


        imageSlider = findViewById(R.id.image_slider);

        AddMember  = findViewById(R.id.add_member);
        AddMember.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( MainActivity.this, AddMember.class ) );
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
        AddAttendence.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( MainActivity.this, AddAttendence.class ) );
            }
        } );

        ContactUs  = findViewById(R.id.contact_us);
        ContactUs.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( MainActivity.this, ContactUs.class ) );
            }
        } );

    }


}