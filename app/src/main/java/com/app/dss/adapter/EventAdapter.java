package com.app.dss.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dss.R;
import com.app.dss.data.Eventlistdata;
import com.app.dss.data.MMlistdata;

import java.util.ArrayList;


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private ArrayList<Eventlistdata> clist;
    private Context mContext;


    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item, and
    //you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //each data item is just a string in this case
        public TextView tv_e_title,tv_e_desc,tv_e_sdate,tv_e_edate;
        public CardView cardview;

        public ViewHolder(View v) {
            super(v);
            tv_e_title = v.findViewById(R.id.tv_e_title);
            tv_e_desc = v.findViewById(R.id.tv_e_desc);
            tv_e_sdate = v.findViewById(R.id.tv_e_sdate);
            tv_e_edate = v.findViewById(R.id.tv_e_edate);
            cardview = v.findViewById(R.id.cardview);

        }
    }

    //Provide a suitable constructor
    public EventAdapter(Context context, ArrayList<Eventlistdata> songList) {
        this.clist = songList;
        this.mContext = context;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Creating a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custome_eventlist, parent, false);

        //set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(EventAdapter.ViewHolder holder, int position) {

        // - get element from arraylist at this position
        // - replace the contents of the view with that element

        final Eventlistdata song = clist.get(position);
        holder.tv_e_title.setText(song.getSm_e_title());
        holder.tv_e_desc.setText("Desc:-"+song.getSm_e_desc());

        Log.e("Statr date",""+song.getSm_e_start_date());
        holder.tv_e_sdate.setText("Start Date:-"+song.getSm_e_start_date());
        holder.tv_e_edate.setText("End Date:-"+song.getSm_e_end_date());


        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent i=new Intent(mContext, FuelplaceActivity.class);
//                i.putExtra("cat_id",song.getF_t_c_id());
//                mContext.startActivity(i);

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
