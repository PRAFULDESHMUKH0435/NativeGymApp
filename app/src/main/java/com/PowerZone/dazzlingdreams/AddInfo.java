package com.PowerZone.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.HashMap;
import java.util.Map;

public class AddInfo extends AppCompatActivity {

    EditText user_name,user_mobno;
    Button user_btn;
    private FirebaseFirestore db;
    private FirebaseStorage storage = FirebaseStorage.getInstance();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_info );

        db = FirebaseFirestore.getInstance();

        user_name = findViewById(R.id.addmember_username);
        user_mobno = findViewById(R.id.addmember_mobilenumber);

        String name = user_name.getText().toString().trim();
        String mobile = user_mobno.getText().toString().trim();


        user_btn = findViewById(R.id.addmember_btn);
        user_btn.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                if (name.isEmpty()){
                    user_name.setError("Required");
                }else if (mobile.length( ) != 10){
                    user_mobno.setError("Required");
                    Toast.makeText( AddInfo.this, "Mobile Number Should Be 10 Digit Long", Toast.LENGTH_SHORT ).show( );
                }else {
                    senddatatobackend(name,mobile);
                }
            }
        } );


    }

    private void senddatatobackend (String name, String mobile) {

        Map<String, Object> enquiry_object = new HashMap<>();
        enquiry_object.put("UserName",name);
        enquiry_object.put("UserMobile",mobile);
        String gymname = "FitnessStar";
        ProgressBar progressBar = findViewById( R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        Task<Void> enquiryPath = db.collection( "GymData").
                document(gymname)
                .collection("Enquiry").document(name)
                .set(enquiry_object)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText( AddInfo.this, "Enquiry Added Successfully", Toast.LENGTH_SHORT ).show( );
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent( AddInfo.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                })
                .addOnFailureListener(e -> {
                    Toast.makeText( AddInfo.this, ""+e.getMessage(), Toast.LENGTH_LONG ).show( );
                    progressBar.setVisibility(View.INVISIBLE);
                });
    }
}