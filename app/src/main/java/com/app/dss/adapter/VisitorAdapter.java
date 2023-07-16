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
import com.app.dss.data.Visitorlistdata;

import java.util.ArrayList;


public class VisitorAdapter extends RecyclerView.Adapter<VisitorAdapter.ViewHolder> {

    private ArrayList<Visitorlistdata> clist;
    private Context mContext;


    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item, and
    //you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //each data item is just a string in this case
        public TextView tv_v_name,tv_v_contact,tv_v_type,tv_v_member,tv_v_time,tv_v_date,tv_v_guardname;
        public CardView cardview;

        public ViewHolder(View v) {
            super(v);
            tv_v_name = v.findViewById(R.id.tv_v_name);
            tv_v_contact = v.findViewById(R.id.tv_v_contact);
            tv_v_type = v.findViewById(R.id.tv_v_type);
            tv_v_member = v.findViewById(R.id.tv_v_member);
            tv_v_time = v.findViewById(R.id.tv_v_time);
            tv_v_date = v.findViewById(R.id.tv_v_date);
            tv_v_guardname = v.findViewById(R.id.tv_v_guardname);

            cardview = v.findViewById(R.id.cardview);

        }
    }

    //Provide a suitable constructor
    public VisitorAdapter(Context context, ArrayList<Visitorlistdata> songList) {
        this.clist = songList;
        this.mContext = context;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public VisitorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Creating a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_visitorlist, parent, false);

        //set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(VisitorAdapter.ViewHolder holder, int position) {

        // - get element from arraylist at this position
        // - replace the contents of the view with that element

        final Visitorlistdata song = clist.get(position);
        holder.tv_v_name.setText("Visitor Name:-"+song.getSm_v_name());
        holder.tv_v_contact.setText("Contact:-"+song.getSm_v_contact());
        holder.tv_v_type.setText("Type:-"+song.getSm_v_type());
        holder.tv_v_member.setText("Member:-"+song.getSm_v_member());

        holder.tv_v_time.setText("Time:-"+song.getSm_v_time());
        holder.tv_v_date.setText("Visit Date:-"+song.getSm_v_c_date());
        holder.tv_v_guardname.setText("Guard Name:-"+song.getSm_v_guardname());



    }

    @Override
    public int getItemCount() {
        return clist.size();
    }
}
