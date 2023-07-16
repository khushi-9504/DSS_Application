package com.app.dss.adapter;


import static com.app.dss.extra.UtilsApi.BASE_URL_API;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dss.R;
import com.app.dss.data.Notilistdata;
import com.app.dss.data.Visitorlistdata;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private ArrayList<Notilistdata> clist;
    private Context mContext;


    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item, and
    //you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //each data item is just a string in this case
        public TextView tv_n_title,tv_n_desc;
        public CardView cardview;
        public CircleImageView iv_npic;

        public ViewHolder(View v) {
            super(v);
            iv_npic = v.findViewById(R.id.iv_npic);
            tv_n_title = v.findViewById(R.id.tv_n_title);
            tv_n_desc = v.findViewById(R.id.tv_n_desc);


            cardview = v.findViewById(R.id.cardview);

        }
    }

    //Provide a suitable constructor
    public NotificationAdapter(Context context, ArrayList<Notilistdata> songList) {
        this.clist = songList;
        this.mContext = context;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Creating a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_notilist, parent, false);

        //set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(NotificationAdapter.ViewHolder holder, int position) {

        // - get element from arraylist at this position
        // - replace the contents of the view with that element

        final Notilistdata song = clist.get(position);
        holder.tv_n_title.setText(song.getSm_n_title());
        holder.tv_n_desc.setText("Desc:-"+song.getSm_n_detail());
        String c_pic=BASE_URL_API+song.getSm_n_pic();
        Picasso.get()
                .load(c_pic)
                .resize(100, 100)
                .centerCrop()
                .into(holder.iv_npic);





    }

    @Override
    public int getItemCount() {
        return clist.size();
    }
}
