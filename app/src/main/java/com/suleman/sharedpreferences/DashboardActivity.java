package com.suleman.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    TextView tvMsg;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tvMsg = (TextView)findViewById(R.id.tvMsg);
        sharedPreferences = getSharedPreferences("login_status",Context.MODE_PRIVATE);
        boolean login = sharedPreferences.getBoolean("login",false);

        editor = sharedPreferences.edit();
        editor.putBoolean("login",true);
        editor.apply();

        if(login)
        {
            tvMsg.setText("With Help of Shared Preferences You Have Redirected To Dashboard Activity");
        }
    }
}
