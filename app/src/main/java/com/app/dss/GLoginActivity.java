package com.app.dss;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.dss.data.Udata;
import com.app.dss.data.WLdata;
import com.app.dss.extra.BaseApiService;
import com.app.dss.extra.SharedPrefManager;
import com.app.dss.extra.UtilsApi;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import im.delight.android.webview.AdvancedWebView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GLoginActivity extends AppCompatActivity  {
    Button bt_login,bt_slogin;
    EditText et_mobile;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glogin);
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(this);
        et_mobile=findViewById(R.id.ed_mobile);
        bt_login=findViewById(R.id.bt_login);
        bt_slogin=findViewById(R.id.bt_slogin);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GLoginActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        bt_slogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile=et_mobile.getText().toString();

                if(!mobile.isEmpty())
                {
                    checklogin(mobile);

                }
                else
                {
                    Toast.makeText(GLoginActivity.this,"Please Enter Mobile Number",Toast.LENGTH_SHORT).show();
                }
//
            }
        });
    }
    private void checklogin(String data) {
        mApiService.dssWLRequest("watchman_login",data).enqueue(new Callback<WLdata>() {
            @Override
            public void onResponse(Call<WLdata> call, Response<WLdata> response) {
                if (response.isSuccessful()){

                    WLdata udata=response.body();
                    if (udata.getStatus().equals("1")){
                        String msg=udata.getMsg();
//    Toast.makeText(LoginActivity.this,""+msg,Toast.LENGTH_SHORT).show();
                        Gson gson = new Gson();
                        String json = gson.toJson(udata);
                        sharedPrefManager.saveSPString(SharedPrefManager.P_ldata, json);
                        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_P_LOGIN, true);
                        startActivity(new Intent(GLoginActivity.this, GMainActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                        finish();

                    }
                    else
                    {
                        String msg=udata.getMsg();
                        Toast.makeText(GLoginActivity.this,""+msg,Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {

                }


            }

            @Override
            public void onFailure(Call<WLdata> call, Throwable t) {

            }
        });
    }
}