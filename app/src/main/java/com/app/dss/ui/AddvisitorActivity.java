package com.app.dss.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.dss.GMainActivity;
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

public class AddvisitorActivity extends AppCompatActivity {
    BaseApiService mApiService;
EditText et_v_name,et_v_contact,et_v_type,et_v_time,et_v_member;
Button bt_addvisitor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addvisitor);
        mApiService = UtilsApi.getAPIService();
        Bundle extras = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        et_v_name=findViewById(R.id.ed_v_name);
        et_v_contact=findViewById(R.id.ed_v_contact);
        et_v_type=findViewById(R.id.ed_v_type);
        et_v_time=findViewById(R.id.ed_v_time);
        et_v_member=findViewById(R.id.ed_v_member);
        bt_addvisitor=findViewById(R.id.bt_addvisitor);
        String u_id = extras.getString("u_id");
        bt_addvisitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v_name=et_v_name.getText().toString();
                String v_conatact=et_v_contact.getText().toString();
                String v_type=et_v_type.getText().toString();
                String v_time=et_v_time.getText().toString();
                String v_member=et_v_member.getText().toString();

                if(!v_name.isEmpty()&& !v_conatact.isEmpty()&&!v_type.isEmpty()&& !v_time.isEmpty()&& !v_member.isEmpty())
                {

                    JSONObject j1=new JSONObject();
                    try {
                        j1.put("sm_v_name",v_name);
                        j1.put("sm_v_type",v_type);
                        j1.put("sm_v_contact",v_conatact);
                        j1.put("sm_v_guardname", GMainActivity.wname);
                        j1.put("u_id",u_id);
                        j1.put("sm_v_member",v_member);
                        j1.put("sm_v_time",v_time);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    String data=j1.toString();
                    addvisitor(data);

                }
                else
                {
                    Toast.makeText(AddvisitorActivity.this,"Enter All Detail",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addvisitor(String data) {
        mApiService.dssaddvisitorRequest("add_visitor",data).enqueue(new Callback<Commondata>() {
            @Override
            public void onResponse(Call<Commondata> call, Response<Commondata> response) {
                if (response.isSuccessful()){

                    Commondata udata=response.body();
                    if (udata.getStatus().equals("1")){
                        String msg=udata.getMsg();
                        et_v_name.setText("");
                        et_v_contact.setText("");
                        et_v_member.setText("");
                        et_v_time.setText("");
                        et_v_type.setText("");
    Toast.makeText(AddvisitorActivity.this,""+msg,Toast.LENGTH_SHORT).show();


                    }
                    else
                    {
                        String msg=udata.getMsg();
                        Toast.makeText(AddvisitorActivity.this,""+msg,Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {

                }


            }

            @Override
            public void onFailure(Call<Commondata> call, Throwable t) {

            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // your code
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }
}