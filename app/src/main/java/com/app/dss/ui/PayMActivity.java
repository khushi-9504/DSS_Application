package com.app.dss.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.dss.LoginActivity;
import com.app.dss.MainActivity;
import com.app.dss.R;
import com.app.dss.data.Commondata;
import com.app.dss.data.UMdata;
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

public class PayMActivity extends AppCompatActivity {
    BaseApiService mApiService;
    TextView tv_m_month,tv_paydate,tv_paystatus,tv_paymode;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    Button bt_pay_m;
    LinearLayout ln_pay_m;
    String m_u_id;
    String ptvalue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_mactivity);
        Bundle extras = getIntent().getExtras();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mApiService = UtilsApi.getAPIService();
        tv_m_month=findViewById(R.id.tv_m_month);
        tv_paydate=findViewById(R.id.tv_paydate);
        tv_paystatus=findViewById(R.id.tv_paystatus);
        tv_paymode=findViewById(R.id.tv_paymode);
        ln_pay_m=findViewById(R.id.ln_pay_m);
        bt_pay_m=findViewById(R.id.bt_p_m);
        radioSexGroup=findViewById(R.id.radioGroup);

        String mm_id = extras.getString("mm_id");
        String mm_m_year = extras.getString("mm_m_year");
        tv_m_month.setText("Maintance Month:-"+mm_m_year);
        Log.e("Pay Man id",""+mm_id);

        JSONObject j1=new JSONObject();
        try {
            j1.put("sm_m_id",mm_id);
            j1.put("u_id",MainActivity.uid);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String data=j1.toString();
        checkmm(data);
        radioSexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                radioSexButton=findViewById(i);
                String ptype=radioSexButton.getText().toString();
                if(ptype.equalsIgnoreCase("Cash"))
                {
//                    ptvalue="1";
                }
                if(ptype.equalsIgnoreCase("Google Pay"))
                {
                    ptvalue="2";

                    String upiurl = "upi://pay?pa=sonamohanty124@gmail.com&pn=8320583558&tn=TestingGpay&am=100&cu=INR";
                    Intent i1 = new Intent(Intent.ACTION_VIEW);
                    i1.setData(Uri.parse(upiurl));
                    startActivity(i1);

                }


            }
        });

bt_pay_m.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        int selectedId=radioSexGroup.getCheckedRadioButtonId();
        radioSexButton=findViewById(selectedId);
        String ptype=radioSexButton.getText().toString();
        if(ptype.equalsIgnoreCase("Cash"))
        {
            ptvalue="1";
        }
        if(ptype.equalsIgnoreCase("Google Pay"))
        {
        ptvalue="2";
        }


        JSONObject j1=new JSONObject();
        try {
            j1.put("m_u_id",m_u_id);
            j1.put("m_u_pay_mode",ptvalue);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String data=j1.toString();
        paymnaitnace(data);

    }
});
    }

    private void paymnaitnace(String data) {
        mApiService.dsspaymRequest("pay_maintance",data).enqueue(new Callback<Commondata>() {
            @Override
            public void onResponse(Call<Commondata> call, Response<Commondata> response) {
                if (response.isSuccessful()){

                    Commondata udata=response.body();
                    if (udata.getStatus().equals("1")){
                        String msg=udata.getMsg();
                        ln_pay_m.setVisibility(View.GONE);
                        tv_paystatus.setText("Pay Status:-Paid");
                        Toast.makeText(PayMActivity.this,""+msg,Toast.LENGTH_SHORT).show();
                        if(ptvalue.equals("1"))
                        {
                            tv_paymode.setText("Pay Mode:-Cash");
                        }
                        if(ptvalue.equals("2"))
                        {
                            tv_paymode.setText("Pay Mode:-Google Pay");
                        }

                    }
                    else
                    {
                        String msg=udata.getMsg();
                        Toast.makeText(PayMActivity.this,""+msg,Toast.LENGTH_SHORT).show();
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

    private void checkmm(String data) {
        mApiService.dssUMRequest("user_maintance",data).enqueue(new Callback<UMdata>() {
            @Override
            public void onResponse(Call<UMdata> call, Response<UMdata> response) {
                if (response.isSuccessful()){

                    UMdata udata=response.body();
                    if (udata.getStatus().equals("1")){
                        String msg=udata.getMsg();
                        tv_paydate.setText("Maintenance Pay Date:-"+udata.getM_u_date());
                        m_u_id=udata.getM_u_id();
                        if(udata.getM_u_status().equals("0"))
                        {
                            ln_pay_m.setVisibility(View.VISIBLE);
                            tv_paystatus.setText("Pay Status:-Pending");
                            tv_paymode.setText("Pay Mode:-");
                        }
                        if(udata.getM_u_status().equals("1"))
                        {
                            ln_pay_m.setVisibility(View.GONE);
                            tv_paystatus.setText("Pay Status:-Paid");

                        }
                        if(udata.getM_u_pay_mode().equals("1"))
                        {
                            tv_paymode.setText("Pay Mode:-Cash");
                        }
                        if(udata.getM_u_pay_mode().equals("2"))
                        {
                            tv_paymode.setText("Pay Mode:-Google Pay");
                        }


                    }
                    else
                    {
                        String msg=udata.getMsg();
                    }
                }
                else
                {

                }


            }

            @Override
            public void onFailure(Call<UMdata> call, Throwable t) {

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