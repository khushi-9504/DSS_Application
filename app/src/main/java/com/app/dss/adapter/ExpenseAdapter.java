package com.app.dss.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dss.R;
import com.app.dss.data.Expenselistdata;
import com.app.dss.data.Incomelistdata;

import java.util.ArrayList;


public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {

    private ArrayList<Expenselistdata> clist;
    private Context mContext;


    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item, and
    //you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //each data item is just a string in this case
        public TextView tv_ex_title,tv_ex_desc,tv_ex_amount,tv_ex_edate,tv_ex_t_name,tv_ex_t_desc;
        public CardView cardview;

        public ViewHolder(View v) {
            super(v);
            tv_ex_title = v.findViewById(R.id.tv_ex_title);
            tv_ex_desc = v.findViewById(R.id.tv_ex_desc);
            tv_ex_amount = v.findViewById(R.id.tv_ex_amount);
            tv_ex_edate = v.findViewById(R.id.tv_ex_edate);
            tv_ex_t_name = v.findViewById(R.id.tv_ex_t_name);
            tv_ex_t_desc = v.findViewById(R.id.tv_ex_t_desc);
            cardview = v.findViewById(R.id.cardview);

        }
    }

    //Provide a suitable constructor
    public ExpenseAdapter(Context context, ArrayList<Expenselistdata> songList) {
        this.clist = songList;
        this.mContext = context;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public ExpenseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Creating a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_expense, parent, false);

        //set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(ExpenseAdapter.ViewHolder holder, int position) {

        // - get element from arraylist at this position
        // - replace the contents of the view with that element

        final Expenselistdata song = clist.get(position);
        holder.tv_ex_title.setText(song.getE_name());
        holder.tv_ex_desc.setText("Desc:-"+song.getSm_e_desc());
        holder.tv_ex_amount.setText("Amount Rs:-"+song.getSm_e_amount());
        holder.tv_ex_edate.setText("Date:-"+song.getSm_e_c_date());

        holder.tv_ex_t_name.setText("Expense Type:-"+song.getE_t_name());
        holder.tv_ex_t_desc.setText("Expense Type Desc:-"+song.getE_t_detail());

    }

    @Override
    public int getItemCount() {
        return clist.size();
    }
}
