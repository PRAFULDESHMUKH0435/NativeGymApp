package com.PowerZone.dazzlingdreams.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.PowerZone.dazzlingdreams.DetailActivity;
import com.PowerZone.dazzlingdreams.Models.DataModel;
import com.PowerZone.dazzlingdreams.R;
import java.util.ArrayList;

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
        holder.UserName.setText(datalist.get(position).getUserName());
        holder.UserMobile.setText(datalist.get(position).getUserMobile());
        String[] st_date = datalist.get( position).getUserStartDate().split( "-");
        String[] en_date = datalist.get( position).getUserEndDate().split( "-");
        holder.Start_Date.setText(st_date[0]);
        holder.End_Date.setText(en_date[0]);
        holder.Start_Month.setText(st_date[1]);
        holder.End_Month.setText(en_date[1]);
        holder.userplan.setText(datalist.get(position).getUserplan());
        holder.bal.setText("Bal :"+datalist.get(position).getBalanceAmount());




    }

    @Override
    public int getItemCount ( ) {
        return datalist.size();
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
