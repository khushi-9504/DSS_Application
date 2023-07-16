package com.app.dss.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dss.R;
import com.app.dss.data.Eventlistdata;
import com.app.dss.data.Incomelistdata;

import java.util.ArrayList;


public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.ViewHolder> {

    private ArrayList<Incomelistdata> clist;
    private Context mContext;


    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item, and
    //you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //each data item is just a string in this case
        public TextView tv_i_title,tv_i_desc,tv_i_amount,tv_i_edate;
        public CardView cardview;

        public ViewHolder(View v) {
            super(v);
            tv_i_title = v.findViewById(R.id.tv_i_title);
            tv_i_desc = v.findViewById(R.id.tv_i_desc);
            tv_i_amount = v.findViewById(R.id.tv_i_amount);
            tv_i_edate = v.findViewById(R.id.tv_i_edate);
            cardview = v.findViewById(R.id.cardview);

        }
    }

    //Provide a suitable constructor
    public IncomeAdapter(Context context, ArrayList<Incomelistdata> songList) {
        this.clist = songList;
        this.mContext = context;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public IncomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Creating a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_income, parent, false);

        //set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(IncomeAdapter.ViewHolder holder, int position) {

        // - get element from arraylist at this position
        // - replace the contents of the view with that element

        final Incomelistdata song = clist.get(position);
        holder.tv_i_title.setText(song.getE_i_title());
        holder.tv_i_desc.setText("Desc:-"+song.getE_i_desc());
        holder.tv_i_amount.setText("Amount:- Rs."+song.getE_i_amount());
        holder.tv_i_edate.setText("Date:-"+song.getE_i_c_date());

    }

    @Override
    public int getItemCount() {
        return clist.size();
    }
}
