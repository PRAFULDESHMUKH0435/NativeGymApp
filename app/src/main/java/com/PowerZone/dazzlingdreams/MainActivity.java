package com.PowerZone.dazzlingdreams;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.dazzlingdreams.R;

import java.util.ArrayList;
import java.util.List;

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


        ImageSlider imageSlider = findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1606889464198-fcb18894cf50?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=490&q=80",ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1588528402605-1f9d0eb7a6d6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80",ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1605296867424-35fc25c9212a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80",ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1583454155184-870a1f63aebc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80",ScaleTypes.FIT));
        imageSlider.setImageList( slideModels, ScaleTypes.FIT);

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


    @Override
    public void onBackPressed ( ) {
        AlertDialog.Builder builder = new AlertDialog.Builder( MainActivity.this);

        // Set the message show for the Alert time
        builder.setMessage("Are You Sure  you want to exit Application ?");

        // Set Alert Title
        builder.setTitle("Confirm Exit ?");

        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            // When the user click yes button then app will close
            finish();
        });

        // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            // If user click no then dialog box is canceled.
            dialog.cancel();
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        alertDialog.show();
    }
}