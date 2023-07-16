package com.app.dss.adapter;


import static com.app.dss.extra.UtilsApi.BASE_URL_API;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dss.R;
import com.app.dss.data.Winglistdata;
import com.app.dss.data.Workerlistdata;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class StaffAdapter extends RecyclerView.Adapter<StaffAdapter.ViewHolder> {

    private ArrayList<Workerlistdata> clist;
    private Context mContext;


    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item, and
    //you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //each data item is just a string in this case
        public TextView tv_w_name,tv_w_role,tv_w_contact,tv_w_salry;
        public CardView cardview;
        public CircleImageView iv_wpic;

        public ViewHolder(View v) {
            super(v);
            tv_w_name = v.findViewById(R.id.tv_w_name);
            tv_w_role = v.findViewById(R.id.tv_w_role);
            tv_w_contact = v.findViewById(R.id.tv_w_contact);
            tv_w_salry = v.findViewById(R.id.tv_w_salry);
            cardview = v.findViewById(R.id.cardview);
            iv_wpic = v.findViewById(R.id.iv_wpic);

        }
    }

    //Provide a suitable constructor
    public StaffAdapter(Context context, ArrayList<Workerlistdata> songList) {
        this.clist = songList;
        this.mContext = context;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public StaffAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Creating a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_workerlist, parent, false);

        //set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(StaffAdapter.ViewHolder holder, int position) {

        // - get element from arraylist at this position
        // - replace the contents of the view with that element

        final Workerlistdata song = clist.get(position);
        holder.tv_w_name.setText(song.getW_s_name());
        holder.tv_w_contact.setText("Contact:-"+song.getW_s_contact());
        holder.tv_w_role.setText("Role:-"+song.getW_s_role());
        holder.tv_w_salry.setText("Salary:- Rs."+song.getW_s_salary());

        String c_pic=BASE_URL_API+"dss_pic/"+song.getW_s_pic();
        Log.e("WOrker pic",c_pic);
        Picasso.get()
                .load(c_pic)
                .resize(100, 100)
                .centerCrop()
                .into(holder.iv_wpic);


    }

    @Override
    public int getItemCount() {
        return clist.size();
    }
}
