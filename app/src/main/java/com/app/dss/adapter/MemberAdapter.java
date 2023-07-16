package com.app.dss.adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dss.R;
import com.app.dss.data.Eventlistdata;
import com.app.dss.data.Memberlistdata;

import java.util.ArrayList;


public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {

    private ArrayList<Memberlistdata> clist;
    private Context mContext;


    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item, and
    //you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //each data item is just a string in this case
        public TextView tv_m_name,tv_m_flatno,tv_m_contact,tv_m_role;
        public CardView cardview;

        public ViewHolder(View v) {
            super(v);
            tv_m_name = v.findViewById(R.id.tv_m_name);
            tv_m_flatno = v.findViewById(R.id.tv_m_flatno);
            tv_m_contact = v.findViewById(R.id.tv_m_contact);
            tv_m_role = v.findViewById(R.id.tv_m_role);
            cardview = v.findViewById(R.id.cardview);

        }
    }

    //Provide a suitable constructor
    public MemberAdapter(Context context, ArrayList<Memberlistdata> songList) {
        this.clist = songList;
        this.mContext = context;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Creating a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_memberlist, parent, false);

        //set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(MemberAdapter.ViewHolder holder, int position) {

        // - get element from arraylist at this position
        // - replace the contents of the view with that element

        final Memberlistdata song = clist.get(position);
        holder.tv_m_name.setText(song.getU_name());
        holder.tv_m_flatno.setText("Flat No:-"+song.getU_flat_no());
        holder.tv_m_contact.setText("Contact:-"+song.getU_mobile());
holder.tv_m_contact.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + song.getU_mobile()));
        mContext.startActivity(intent);

    }
});


        holder.tv_m_role.setText("Role:-"+song.getU_role());


        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent i=new Intent(mContext, FuelplaceActivity.class);
//                i.putExtra("cat_id",song.getF_t_c_id());
//                mContext.startActivity(i);




            }
        });


    }

    @Override
    public int getItemCount() {
        return clist.size();
    }
}
