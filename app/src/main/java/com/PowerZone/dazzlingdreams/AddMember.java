package com.PowerZone.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dazzlingdreams.R;
import com.github.dhaval2404.imagepicker.ImagePicker;

import java.util.Calendar;


public class AddMember extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    private Button pickDateBtn, EndDateBtn,ImgButton , RegisterUser;
    String []plans = {"Monthly","Quarterly","Half Yearly","Yearly"};
    String plan ="", start_date="" ,end_date="";
    boolean isloading = false;
    ArrayAdapter<String> adapteritems;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_member );

        getSupportActionBar().setTitle("Add Members");


        HelperServices  helperService = new HelperServices();

        ///////////
        String username = findViewById( R.id.username).toString();
        String email = findViewById( R.id.email).toString();
        String mobno = findViewById( R.id.phonenumber).toString();
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
                if (!(username.isEmpty() || email.isEmpty() || mobno.isEmpty() || plan.isEmpty() || start_date.isEmpty() || end_date.isEmpty())){
                        helperService.SaveDataToFireStoreDatabase("FitnessStar",username,email,mobno,plan,start_date,end_date,"65");
                    Toast.makeText( AddMember.this, "Method Hitted Sucessfully", Toast.LENGTH_SHORT ).show( );
                }else {
                    Toast.makeText( AddMember.this, "All Fields Are Required", Toast.LENGTH_SHORT ).show( );
                }
            }
        } );

    }




}