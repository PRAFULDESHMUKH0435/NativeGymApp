package com.PowerZone.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.PowerZone.dazzlingdreams.Adapters.DataAdapter;
import com.PowerZone.dazzlingdreams.Adapters.EnquiryAdapter;
import com.PowerZone.dazzlingdreams.Models.DataModel;
import com.PowerZone.dazzlingdreams.Models.EnquiryModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;

public class AddEnquiry extends AppCompatActivity {

    FloatingActionButton fab ;
    RecyclerView recview;
    ArrayList<EnquiryModel> enquirylist;
    FirebaseFirestore db;
    EnquiryAdapter enquiryadapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_attendence );

        getSupportActionBar().setTitle("Add Enquiry");

        fab=findViewById(R.id.floatingActionButton);
        fab.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick (View v) {
                startActivity( new Intent( AddEnquiry.this,AddInfo.class ) );
            }
        } );








        recview=(RecyclerView)findViewById(R.id.recyclerView);
        recview.setLayoutManager(new LinearLayoutManager( this));
        enquirylist=new ArrayList<>();
        enquiryadapter=new EnquiryAdapter(enquirylist);
        recview.setAdapter(enquiryadapter);
//        ProgressBar progressBar = findViewById( R.id.progressBar2);
//        progressBar.setVisibility( View.VISIBLE);

        db= FirebaseFirestore.getInstance();
        db.collection( "GymData").
                document("FitnessStar")
                .collection("Enquiry")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            EnquiryModel obj=d.toObject(EnquiryModel.class);
                            enquirylist.add(obj);
                        }
                        enquiryadapter.notifyDataSetChanged();
//                        progressBar.setVisibility( View.INVISIBLE);
                    }
                });

    }
}