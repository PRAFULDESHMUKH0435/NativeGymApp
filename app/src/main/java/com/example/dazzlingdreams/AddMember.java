package com.example.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class AddMember extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    String []plans = {"Monthly","Quarterly","Half Yearly","Yearly"};
    ArrayAdapter<String> adapteritems;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_member );


        autoCompleteTextView = findViewById(R.id.auto_completetext1);
        adapteritems = new ArrayAdapter<>( this, R.layout.list_item, plans );
        autoCompleteTextView.setAdapter(adapteritems);
        autoCompleteTextView.setOnItemClickListener( new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int position, long id) {
                String item = adapterView.getItemAtPosition(position).toString();
            }
        } );

    }
}