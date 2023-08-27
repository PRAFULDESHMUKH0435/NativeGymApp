package com.PowerZone.dazzlingdreams.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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
        holder.Start_Date.setText( (CharSequence) datalist.get( position).getStart_Date());
        holder.End_Date.setText( (CharSequence) datalist.get( position).getEnd_Date());
//        holder.Start_Month.setText(datalist.get(position).getUserName());
//        holder.End_Month.setText(datalist.get(position).getUserName());
        holder.userplan.setText(datalist.get(position).getUserplan());

    }

    @Override
    public int getItemCount ( ) {
        return datalist.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView UserName,UserMobile,Start_Date,End_Date,Start_Month,End_Month,userplan;
        public myviewholder (@NonNull View itemView) {
            super( itemView );
            UserName =itemView.findViewById(R.id.username);
            UserMobile =itemView.findViewById(R.id.usermobile);
            Start_Date =itemView.findViewById(R.id.startdate);
            End_Date =itemView.findViewById(R.id.enddate);
            Start_Month =itemView.findViewById(R.id.startmonth);
            End_Month =itemView.findViewById(R.id.endmonth);
            userplan =itemView.findViewById(R.id.plan);
        }
    }
}
