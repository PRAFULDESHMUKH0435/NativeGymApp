package com.PowerZone.dazzlingdreams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.dazzlingdreams.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageSlider mainslider;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mainslider=(ImageSlider)findViewById(R.id.image_slider);
        final List<SlideModel> remoteimages=new ArrayList<>();
        FirebaseDatabase.getInstance().getReference().child( "ImageSlider")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                        for(DataSnapshot data:dataSnapshot.getChildren())
                            remoteimages.add(new SlideModel(data.child("url").getValue().toString(), ScaleTypes.FIT));
//                        data.child("title").getValue().toString()
                        mainslider.setImageList( remoteimages, ScaleTypes.FIT);

                        mainslider.setItemClickListener(new ItemClickListener() {
                            @Override
                            public void onItemSelected(int i) {
                                Toast.makeText( getApplicationContext(), "Image "+(i+1)+" Clicked ", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText( MainActivity.this, ""+databaseError.getMessage().toUpperCase(), Toast.LENGTH_SHORT ).show( );

                    }
                });
    }


}