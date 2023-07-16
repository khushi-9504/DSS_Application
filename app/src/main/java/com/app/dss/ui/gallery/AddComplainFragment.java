package com.app.dss.ui.gallery;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.app.dss.LoginActivity;
import com.app.dss.MainActivity;
import com.app.dss.R;
import com.app.dss.data.Commondata;
import com.app.dss.data.Udata;
import com.app.dss.extra.BaseApiService;
import com.app.dss.extra.SharedPrefManager;
import com.app.dss.extra.UtilsApi;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddComplainFragment extends Fragment{

    EditText et_c_title,et_c_desc;
    Button bt_complaint;
    Spinner sp_c_type;
    String[] Complaint = { "Repair", "Lost", "Clean", "Staff", "Visitor"};
    String sp_c_name;
    BaseApiService mApiService;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_addcomplaint, container, false);
        et_c_title=rootView.findViewById(R.id.ed_c_titile);
        et_c_desc=rootView.findViewById(R.id.ed_c_desc);
        bt_complaint=rootView.findViewById(R.id.bt_complaint);
        sp_c_type = rootView.findViewById(R.id.sp_c_type);
        mApiService = UtilsApi.getAPIService();

        ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Complaint);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        sp_c_type.setAdapter(aa);
        sp_c_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                sp_c_name=Complaint[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bt_complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c_title=et_c_title.getText().toString();
                String c_desc=et_c_desc.getText().toString();
                if(!c_title.isEmpty()&&!c_desc.isEmpty())
                {
                    JSONObject j1=new JSONObject();
                    try {
                        j1.put("sm_u_title",c_title);
                        j1.put("sm_u_desc",c_desc);
                        j1.put("sm_u_c_type",sp_c_name);
                        j1.put("sm_u_id", MainActivity.uid);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    String data=j1.toString();
                    addcomplaint(data);

                }
                else
                {
                    Toast.makeText(getActivity(),"Please Fill Up Form",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }

    private void addcomplaint(String data) {
        mApiService.dssaddcomplaintRequest("add_complaint",data).enqueue(new Callback<Commondata>() {
            @Override
            public void onResponse(Call<Commondata> call, Response<Commondata> response) {
                if (response.isSuccessful()){
                    Commondata udata=response.body();
                    if (udata.getStatus().equals("1")){
                        String msg=udata.getMsg();
                        Toast.makeText(getActivity(),""+msg,Toast.LENGTH_SHORT).show();
                        et_c_title.setText("");
                        et_c_desc.setText("");
                    }
                    else
                    {
                        String msg=udata.getMsg();
                        Toast.makeText(getActivity(),""+msg,Toast.LENGTH_SHORT).show();
                    }
                }



            }

            @Override
            public void onFailure(Call<Commondata> call, Throwable t) {

            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}