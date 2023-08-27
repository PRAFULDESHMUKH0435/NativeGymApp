package com.PowerZone.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.dhaval2404.imagepicker.ImagePicker;

public class RegisterActivity extends AppCompatActivity {

    private Button ImgButton;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );



        ImgButton = findViewById(R.id.img_button);
        ImgButton.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                ImagePicker.with( RegisterActivity.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        } );
    }
}