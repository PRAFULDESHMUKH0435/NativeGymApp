package com.PowerZone.dazzlingdreams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.PowerZone.dazzlingdreams.Adapters.DataAdapter;
import com.PowerZone.dazzlingdreams.Models.DataModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShowMembers extends AppCompatActivity {

    RecyclerView recview;
    ArrayList<DataModel> datalist;
    FirebaseFirestore db;
    DataAdapter adapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_show_members );
        getSupportActionBar().setTitle("Show Members");


        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager( this));
        datalist=new ArrayList<>();
        adapter=new DataAdapter(datalist);
        recview.setAdapter(adapter);
        ProgressBar progressBar = findViewById( R.id.progressBar2);
        progressBar.setVisibility( View.VISIBLE);

        db=FirebaseFirestore.getInstance();
        db.collection( "GymData").
                document("FitnessStar")
                .collection("ClientData")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            DataModel obj=d.toObject(DataModel.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                        progressBar.setVisibility( View.INVISIBLE);
                    }
                });
    }



    ///////////////////////////////////////////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.searchmenu,menu);

        MenuItem item=menu.findItem( R.id.search);

        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }



    private void processsearch(String s)
    {
//        FirebaseRecyclerOptions<DataModel> options =
//                new FirebaseRecyclerOptions.Builder<model>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("students").orderByChild("course").startAt(s).endAt(s+"\uf8ff"), model.class)
//                        .build();
//
//        adapter=new DataAdapter(options);
//        adapter.startListening();
//        recview.setAdapter(adapter);

    }


}