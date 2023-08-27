package com.PowerZone.dazzlingdreams;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;

import android.widget.EditText;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class AddMember extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    private Button pickDateBtn, EndDateBtn,ImgButton , RegisterUser;
    String []plans = {"Monthly","Quarterly","Half Yearly","Yearly"};
    String plan ="", start_date="" ,end_date="",UserName="",UserWeight="",UserMobile="",gymname="";

    ArrayAdapter<String> adapteritems;
    private FirebaseFirestore db;
    private FirebaseStorage storage = FirebaseStorage.getInstance();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_member );

        getSupportActionBar().setTitle("Register Member");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        db = FirebaseFirestore.getInstance();

        ///////////
        EditText username = findViewById( R.id.username);
        EditText userweight = findViewById( R.id.weight);
        EditText usermobno = findViewById( R.id.phonenumber);
        gymname = "FitnessStar";
        //////////

        autoCompleteTextView = findViewById(R.id.auto_completetext1);
        adapteritems = new ArrayAdapter<>( this, R.layout.list_item, plans );
        autoCompleteTextView.setAdapter(adapteritems);
        autoCompleteTextView.setOnItemClickListener( new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int position, long id) {
                 plan = adapterView.getItemAtPosition(position).toString();
            }
        } );

        pickDateBtn = findViewById(R.id.start_date);
        pickDateBtn.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get( Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddMember.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                 start_date = dayOfMonth+"-"+(monthOfYear+1)+"-"+year;
                                pickDateBtn.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        },

                        year, month, day);
                datePickerDialog.show();
            }
        } );

        EndDateBtn = findViewById(R.id.end_date);
        EndDateBtn.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get( Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddMember.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                 end_date = dayOfMonth+"-"+(monthOfYear+1)+"-"+year;
                                EndDateBtn.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        },

                        year, month, day);
                datePickerDialog.show();
            }
        } );

        ImgButton = findViewById(R.id.chooseimg_button);
        ImgButton.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                ImagePicker.with(AddMember.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        } );


        RegisterUser = findViewById(R.id.btnRegister);
        RegisterUser.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                 UserName= username.getText().toString().trim();
                 UserWeight= userweight.getText().toString().trim();
                 UserMobile= usermobno.getText().toString().trim();
                 gymname = "FitnessStar";
                 if (TextUtils.isEmpty(UserName)) {
                     username.setError("Required");
                 }else if (TextUtils.isEmpty(UserWeight)) {
                     userweight.setError("Required");
                 }else if (TextUtils.isEmpty(UserMobile)) {
                     usermobno.setError("Required");
                 }else if (usermobno.length()!=10){
                     Toast.makeText( AddMember.this, "Mobile Number Should Be 10 Digit Long", Toast.LENGTH_SHORT ).show( );
                 }
                 else if (plan.isEmpty() || start_date.isEmpty() || end_date.isEmpty()) {
                     Toast.makeText( AddMember.this, "Complete All Fields", Toast.LENGTH_SHORT ).show( );
                 }else {
                     ShowAlertDialog("Are You Sure You Want To Add "+UserName +" To Gym Data");
                 }

            }
        } );
    }

    void ShowAlertDialog(String msg){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder( this);
        alertDialogBuilder.setTitle("Confirmation");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                ADDING USER TO GYM DATA
                Map<String, Object> user_object = new HashMap<>();
                    user_object.put("UserName",UserName);
                    user_object.put("UserWeight",UserWeight);
                    user_object.put("UserMobile",UserMobile);
                    user_object.put("UserPlan",plan);
                    user_object.put("UserStartDate",start_date);
                    user_object.put("UserEndDate",end_date);

                Task<Void> userPath = db.collection( "GymData").
                        document(gymname)
                        .collection("ClientData").document(UserName)
                        .set(user_object)
                        .addOnSuccessListener(documentReference -> {
                            Toast.makeText( AddMember.this, "Data Added Successfully", Toast.LENGTH_SHORT ).show( );
                            Intent intent = new Intent(AddMember.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText( AddMember.this, ""+e.getMessage(), Toast.LENGTH_LONG ).show( );
                        });
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when the "Cancel" button is clicked
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    // Create and show the alert dialog


}