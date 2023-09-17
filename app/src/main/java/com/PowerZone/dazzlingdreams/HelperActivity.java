package com.PowerZone.dazzlingdreams;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.PowerZone.dazzlingdreams.Adapters.DataAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class HelperActivity {

    public static void deleteuserfromdatabase(String name){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference userRef = db.collection("GymData")
        .document("FitnessStar")
        .collection("ClientData").document(name);
        userRef.delete()
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {

                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
    }

    public static void deleteuserenquiryfromdatabase(String ename){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference userRef = db.collection("GymData")
                .document("FitnessStar")
                .collection("Enquiry").document(ename);
        userRef.delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }




}
