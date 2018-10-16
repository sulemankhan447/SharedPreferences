package com.suleman.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtUsername;
    EditText edtPassword;
    static String username;
    static String password;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("login_status",Context.MODE_PRIVATE);
        edtUsername = (EditText)findViewById(R.id.edtUsername);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        boolean login = sharedPreferences.getBoolean("login",false);
        if(login)
        {
            startActivity(new Intent(this,DashboardActivity.class));
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = edtUsername.getText().toString();
                password = edtPassword.getText().toString();
                if (username.equals("suleman") && password.equals("suleman")) {

                    startActivity(new Intent(MainActivity.this,DashboardActivity.class));
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Incorrect username or Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
