package com.example.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;

import com.github.dhaval2404.imagepicker.ImagePicker;

import java.util.Calendar;


public class AddMember extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    private Button pickDateBtn, EndDateBtn,ImgButton;
    String []plans = {"Monthly","Quarterly","Half Yearly","Yearly"};
    ArrayAdapter<String> adapteritems;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_member );

        getSupportActionBar().setTitle("Add Member");

        autoCompleteTextView = findViewById(R.id.auto_completetext1);
        adapteritems = new ArrayAdapter<>( this, R.layout.list_item, plans );
        autoCompleteTextView.setAdapter(adapteritems);
        autoCompleteTextView.setOnItemClickListener( new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int position, long id) {
                String item = adapterView.getItemAtPosition(position).toString();
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
                                String start = dayOfMonth+"-"+(monthOfYear+1)+"-"+year;
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
                                String end = dayOfMonth+"-"+(monthOfYear+1)+"-"+year;
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

    }




}