package com.PowerZone.dazzlingdreams;
import static android.content.ContentValues.TAG;

import android.util.Log;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class HelperServices {
    private FirebaseFirestore db;
    public void  SaveDataToFireStoreDatabase(String GymName, String username , String useremail,String usermobile,String userplan,String start_date,String end_date,String userweight){
        db = FirebaseFirestore.getInstance();
        Map<String, Object> user_object = new HashMap<>();
        user_object.put("UserName",username );
        user_object.put("UserEmail",useremail );
        user_object.put("UserMobile",usermobile );
        user_object.put("UserPlan",userplan );
        user_object.put("UserStartDate",start_date );
        user_object.put("UserEndDate",end_date );
        user_object.put("UserWeight",userweight );


        db.collection(GymName).document("ClientData")
                .set(user_object)
//                .add(user_object)
                .addOnSuccessListener(documentReference -> {
                    // Document added successfully
                })
                .addOnFailureListener(e -> {
                    // Error adding document
                });
    }


    public  void  ShowToast(String message){

    }


}
