package com.PowerZone.dazzlingdreams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.PowerZone.dazzlingdreams.Adapters.DataAdapter;
import com.PowerZone.dazzlingdreams.Models.DataModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;

public class ShowMembers extends AppCompatActivity {

    RecyclerView recview;
    ArrayList<DataModel> datalist;
    FirebaseFirestore db;
    static DataAdapter adapter;

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



        ///////////////////////////////////////////////////////
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        EditText searchEditText = findViewById(R.id.searchEditText);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // No action needed here
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String searchText = charSequence.toString().trim();
                searchFirestore(searchText);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // No action needed here
            }
        });
    }

    private void searchFirestore(String searchText) {
            CollectionReference collectionRef = db.collection("GymData").
                     document("FitnessStar")
                    .collection("ClientData");
            Query query = collectionRef.whereEqualTo("Ganesh Sir", searchText);

            query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        List<DataModel> searchResults = new ArrayList<>();
                        searchResults.clear();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            DataModel data = document.toObject(DataModel.class);
                            searchResults.add(data);
                        }

                        // Update your RecyclerView adapter with searchResults
//                        adapter.notifyDataSetChanged();
                        adapter = new DataAdapter(datalist);
                        adapter.notifyDataSetChanged();
                        adapter.updateData(searchResults);
                    } else {
                        Toast.makeText(ShowMembers.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }

}