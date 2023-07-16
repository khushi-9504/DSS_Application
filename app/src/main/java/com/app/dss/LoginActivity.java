package com.app.dss;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.dss.data.Udata;
import com.app.dss.extra.BaseApiService;
import com.app.dss.extra.SharedPrefManager;
import com.app.dss.extra.UtilsApi;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button bt_login,bt_slogin,bt_play;
    EditText et_email,et_password;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(this);
        if (sharedPrefManager.getUserLogin()){
            Intent i =new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        if (sharedPrefManager.getSPSudahLogin()){
            Intent i =new Intent(LoginActivity.this,GMainActivity.class);
            startActivity(i);
            finish();
        }
        et_email=findViewById(R.id.ed_email);
        et_password=findViewById(R.id.ed_password);
        bt_login=findViewById(R.id.bt_login);
        bt_slogin=findViewById(R.id.bt_slogin);
        bt_play=findViewById(R.id.bt_play);
        bt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.agame.com/games/mobile__tablet_games";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });
        bt_slogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,GLoginActivity.class);
                startActivity(i);
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=et_email.getText().toString();
                String paswor=et_password.getText().toString();

                if(!email.isEmpty()&&!paswor.isEmpty())
                {
                    JSONObject j1=new JSONObject();
                    try {
                        j1.put("u_email",email);
                        j1.put("u_pwd",paswor);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    String data=j1.toString();
                    checklogin(data);

                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Please Enter email and Password",Toast.LENGTH_SHORT).show();
                }
//
            }
        });

        checkAndRequestPermissions();
    }

    private void checklogin(String data) {
        Log.e("Login Data",data);
        mApiService.dssloginRequest("user_login",data).enqueue(new Callback<Udata>() {
            @Override
            public void onResponse(Call<Udata> call, Response<Udata> response) {
                if (response.isSuccessful()){

                    Udata udata=response.body();
                    if (udata.getStatus().equals("1")){
    String msg=udata.getMsg();
//    Toast.makeText(LoginActivity.this,""+msg,Toast.LENGTH_SHORT).show();
                        Gson gson = new Gson();
                        String json = gson.toJson(udata);
                        sharedPrefManager.saveSPString(SharedPrefManager.F_ldata, json);
                        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_F_LOGIN, true);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                        finish();

                    }
                    else
                    {
                        String msg=udata.getMsg();
                        Toast.makeText(LoginActivity.this,""+msg,Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {

                }


            }

            @Override
            public void onFailure(Call<Udata> call, Throwable t) {

            }
        });
    }

    private  boolean checkAndRequestPermissions() {
        int camera = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA);
        int storage = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        int loc = ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION);
        int loc2 = ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION);
        List<String> listPermissionsNeeded = new ArrayList<>();

        if (camera != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.CAMERA);
        }
        if (storage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CALL_PHONE);
        }
        if (loc2 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (loc != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (!listPermissionsNeeded.isEmpty())
        {
            ActivityCompat.requestPermissions(this,listPermissionsNeeded.toArray
                    (new String[listPermissionsNeeded.size()]),REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }
}