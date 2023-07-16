package com.app.dss;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.dss.data.Udata;
import com.app.dss.data.WLdata;
import com.app.dss.extra.SharedPrefManager;
import com.google.gson.Gson;

public class GMainActivity extends AppCompatActivity {
    SharedPrefManager sharedPrefManager;
    WLdata fp;
    public  static  String wname;
    TextView tv_gname;
    Button bt_addvisitor,bt_visitor_list,bt_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmain);
        sharedPrefManager = new SharedPrefManager(this);
        String fdata=sharedPrefManager.getPdata();
        Gson gson = new Gson();
        fp = gson.fromJson(fdata, WLdata.class);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_gname=findViewById(R.id.tv_gname);
        bt_addvisitor=findViewById(R.id.bt_addvisitor);
        bt_visitor_list=findViewById(R.id.bt_visitor);
        bt_logout=findViewById(R.id.bt_logout);
        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GMainActivity.this);
                builder.setTitle("Logout");
                builder.setMessage("Are u sure want to logout?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_P_LOGIN, false);
                        Intent i=new Intent(GMainActivity.this,GLoginActivity.class);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
        tv_gname.setText("Guard Name:-"+fp.getW_name());
        wname=fp.getW_name();
        bt_addvisitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GMainActivity.this,SwingActivity.class);
                startActivity(i);

            }
        });
        bt_visitor_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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