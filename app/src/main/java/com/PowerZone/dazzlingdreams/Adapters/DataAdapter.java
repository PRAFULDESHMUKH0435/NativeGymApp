package com.PowerZone.dazzlingdreams.Adapters;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.PowerZone.dazzlingdreams.HelperActivity;
import com.PowerZone.dazzlingdreams.MainActivity;
import com.PowerZone.dazzlingdreams.Models.DataModel;
import com.PowerZone.dazzlingdreams.R;
import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.myviewholder> {

    ArrayList<DataModel> datalist;
    public DataAdapter(ArrayList<DataModel> datalist) {
        this.datalist = datalist;
    }


    @NonNull
    @Override
    public DataAdapter.myviewholder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( parent.getContext()).inflate( R.layout.single_row, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull DataAdapter.myviewholder holder, int position) {
        String uname = datalist.get(position).getUserName();
        holder.UserName.setText(uname);
        holder.UserMobile.setText(datalist.get(position).getUserMobile());
        String[] st_date = datalist.get( position).getUserStartDate().split( "-");
        String[] en_date = datalist.get( position).getUserEndDate().split( "-");
        holder.Start_Date.setText(st_date[0]);
        holder.End_Date.setText(en_date[0]);
        holder.Start_Month.setText(st_date[1]);
        holder.End_Month.setText(en_date[1]);
        holder.userplan.setText(datalist.get(position).getUserplan());
        holder.bal.setText("Bal :"+datalist.get(position).getBalanceAmount());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ///////////////////////////////////////
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Are You Sure you want to Delete "+uname.toUpperCase() +" From Membership ?\n Once You Delete You Wont Be Able To Retrieve The Member");
                builder.setTitle("Confirm Deletion ?");

                builder.setCancelable(false);

                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    HelperActivity.deleteuserfromdatabase(uname);
                    updateData(datalist);
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
    public int getItemCount ( ) {
        return datalist.size();
    }

    public void updateData(List<DataModel> searchResults) {
//        datalist.clear();
//        datalist.addAll(searchResults);
        notifyDataSetChanged();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView UserName,UserMobile,Start_Date,End_Date,Start_Month,End_Month,userplan,bal;
        public myviewholder (@NonNull View itemView) {
            super( itemView );
            UserName =itemView.findViewById(R.id.username);
            UserMobile =itemView.findViewById(R.id.usermobile);
            Start_Date =itemView.findViewById(R.id.startdate);
            End_Date =itemView.findViewById(R.id.enddate);
            Start_Month =itemView.findViewById(R.id.startmonth);
            End_Month =itemView.findViewById(R.id.endmonth);
            userplan =itemView.findViewById(R.id.plan);
            bal = itemView.findViewById(R.id.balance);
        }
    }
}
