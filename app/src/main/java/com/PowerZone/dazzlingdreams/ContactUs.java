package com.PowerZone.dazzlingdreams;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.inputmethodservice.Keyboard;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import java.util.List;


public class ContactUs extends AppCompatActivity {

    ImageView developer,excel,profileimage;
    TextView name,mobile,address,email,gymname;
    FirebaseDatabase database;
    DatabaseReference ref;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_contact_us );

        getSupportActionBar().setTitle("Profile ");
        profileimage = findViewById(R.id.profileImageView);
        name = findViewById(R.id.nameTextView);
        mobile = findViewById(R.id.mobileNumberTextView);
        address = findViewById(R.id.addressTextView);
        email = findViewById(R.id.emailAddressTextView);
        gymname = findViewById(R.id.gymnameTextView);


        database = FirebaseDatabase.getInstance( );
        ref = FirebaseDatabase.getInstance( ).getReference( )
                .child("GymOwner")
                .child("RameshRamGundewar");
        ref.addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange (@NonNull DataSnapshot snapshot) {
                String name1 = snapshot.child("name").getValue().toString();
                String email1 = snapshot.child( "email").getValue().toString( );
                String number1 = snapshot.child( "mobile").getValue().toString();
                String gymname1 = snapshot.child( "gymname").getValue().toString();
                String address1 = snapshot.child( "address").getValue().toString();

                name.setText(name1);
                email.setText("Email : "+email1);
                mobile.setText("Mobile  : "+number1);
                gymname.setText("GymName : "+gymname1);
                address.setText("Address : "+address1);
            }

            @Override
            public void onCancelled (@NonNull DatabaseError error) {
                Toast.makeText(ContactUs.this, "Error In Getting Your Data From Server", Toast.LENGTH_SHORT ).show( );
            }
        } );




































        ////////////////////////////////////////////////////////////////////////////
        developer = findViewById(R.id.developer);
        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "+919359407730";
                String message = "Hello, this is a WhatsApp message from my Android app!";
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("https://wa.me/" + phoneNumber);
                sendIntent.setData(uri);
                sendIntent.putExtra(Intent.EXTRA_TEXT,message);
                startActivity(sendIntent);
            }
        });




        excel = findViewById(R.id.excel);
        excel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void generateExcelFile(List<DocumentSnapshot> documents) {
    }
}