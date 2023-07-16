package com.app.dss.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dss.R;
import com.app.dss.data.Complaintdata;
import com.app.dss.data.Complaintlistdata;
import com.app.dss.data.Visitorlistdata;

import java.util.ArrayList;


public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.ViewHolder> {

    private ArrayList<Complaintlistdata> clist;
    private Context mContext;


    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item, and
    //you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //each data item is just a string in this case
        public TextView tv_c_title,tv_c_desc,tv_c_type,tv_c_status,tv_r_date,tv_c_date;
        public CardView cardview;

        public ViewHolder(View v) {
            super(v);
            tv_c_title = v.findViewById(R.id.tv_c_title);
            tv_c_desc = v.findViewById(R.id.tv_c_desc);
            tv_c_type = v.findViewById(R.id.tv_c_type);
            tv_c_status = v.findViewById(R.id.tv_c_status);
            tv_r_date = v.findViewById(R.id.tv_r_date);
            tv_c_date = v.findViewById(R.id.tv_c_date);

            cardview = v.findViewById(R.id.cardview);

        }
    }

    //Provide a suitable constructor
    public ComplaintAdapter(Context context, ArrayList<Complaintlistdata> songList) {
        this.clist = songList;
        this.mContext = context;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public ComplaintAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Creating a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_complaint, parent, false);

        //set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(ComplaintAdapter.ViewHolder holder, int position) {

        // - get element from arraylist at this position
        // - replace the contents of the view with that element

        final Complaintlistdata song = clist.get(position);
        holder.tv_c_title.setText("Title:-"+song.getSm_u_title());
        holder.tv_c_desc.setText("Desc:-"+song.getSm_u_desc());
        holder.tv_c_type.setText("Type:-"+song.getSm_u_c_type());
        holder.tv_c_date.setText("Complain Date:-"+song.getSm_u_c_date());
        holder.tv_r_date.setText("Resolve Date:-"+song.getSm_u_r_date());
        if(song.getSm_u_status().equals("0"))
        {
            holder.tv_c_status.setText("Status:- Pending");
        }
        if(song.getSm_u_status().equals("1"))
        {
            holder.tv_c_status.setText("Status:- Solve");
        }



    }

    @Override
    public int getItemCount() {
        return clist.size();
    }
}
