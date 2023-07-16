package com.app.dss.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dss.R;
import com.app.dss.data.Winglistdata;
import com.app.dss.ui.GMemberActivity;
import com.app.dss.ui.MemberActivity;

import java.util.ArrayList;


public class GWingAdapter extends RecyclerView.Adapter<GWingAdapter.ViewHolder> {

    private ArrayList<Winglistdata> clist;
    private Context mContext;


    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item, and
    //you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //each data item is just a string in this case
        public TextView tv_w_name;
        public CardView cardview;

        public ViewHolder(View v) {
            super(v);
            tv_w_name = v.findViewById(R.id.tv_w_name);
            cardview = v.findViewById(R.id.cardview);

        }
    }

    //Provide a suitable constructor
    public GWingAdapter(Context context, ArrayList<Winglistdata> songList) {
        this.clist = songList;
        this.mContext = context;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public GWingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Creating a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_wing, parent, false);

        //set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(GWingAdapter.ViewHolder holder, int position) {

        // - get element from arraylist at this position
        // - replace the contents of the view with that element

        final Winglistdata song = clist.get(position);
        holder.tv_w_name.setText(song.getW_name());


        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(mContext, GMemberActivity.class);
                i.putExtra("w_id",song.getW_id());
                mContext.startActivity(i);

//                FuelPlaceFragment docofragemnt=new FuelPlaceFragment();
//                Bundle arguments = new Bundle();
//                arguments.putString("cat_id",song.getF_t_c_id());
//                docofragemnt.setArguments(arguments);
//                FragmentManager manager = ((AppCompatActivity)
//                        mContext).getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = manager.beginTransaction();
//                fragmentTransaction.replace(R.id.nav_host_fragment_content_main,  docofragemnt);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();


            }
        });


    }

    @Override
    public int getItemCount() {
        return clist.size();
    }
}
