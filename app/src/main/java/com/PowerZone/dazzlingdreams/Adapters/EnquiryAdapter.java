package com.PowerZone.dazzlingdreams.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.PowerZone.dazzlingdreams.AddEnquiry;
import com.PowerZone.dazzlingdreams.AddMember;
import com.PowerZone.dazzlingdreams.HelperActivity;
import com.PowerZone.dazzlingdreams.MainActivity;
import com.PowerZone.dazzlingdreams.Models.EnquiryModel;
import com.PowerZone.dazzlingdreams.R;

import java.util.ArrayList;
public class EnquiryAdapter extends RecyclerView.Adapter<EnquiryAdapter.myviewholder>  {

    Context context;
    ArrayList<EnquiryModel> enquirylist;

    public EnquiryAdapter(Context context) {
        this.context = context;
    }

    public EnquiryAdapter(ArrayList<EnquiryModel> enquirylist) {
        this.enquirylist = enquirylist;
    }

    @NonNull
    @Override
    public EnquiryAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( parent.getContext()).inflate( R.layout.enquiry_row, parent, false);
        return new EnquiryAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EnquiryAdapter.myviewholder holder, int position) {
        holder.UserName.setText(enquirylist.get(position).getUserName());
        holder.UserMobile.setText(enquirylist.get(position).getUserMobile());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, AddMember.class);
                intent.putExtra("uname",enquirylist.get(position).getUserName());
                intent.putExtra("umobile", enquirylist.get(position).getUserMobile());
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ///////////////////////////////////////
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setMessage("Are You Sure you want to Delete "+enquirylist.get(position).getUserName().toUpperCase() +" From Enquiry List ?\n Once You Delete You Wont Be Able To Retrieve The Member");
                builder.setTitle("Confirm Deletion ?");

                builder.setCancelable(false);

                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    HelperActivity.deleteuserenquiryfromdatabase(enquirylist.get(position).getUserName());
                });

                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    dialog.cancel();
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return enquirylist.size();
    }




    public class myviewholder extends RecyclerView.ViewHolder {
        TextView UserName,UserMobile;
        Button btn ;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            UserName =itemView.findViewById(R.id.username_en);
            UserMobile =itemView.findViewById(R.id.usermobile_en);
            btn = itemView.findViewById(R.id.button3);
        }
    }
}
