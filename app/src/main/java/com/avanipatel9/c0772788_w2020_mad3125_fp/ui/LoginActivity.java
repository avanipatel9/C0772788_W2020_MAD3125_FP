package com.avanipatel9.c0772788_w2020_mad3125_fp.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity {


    @InjectView(R.id.username)
    TextInputLayout username;
    @InjectView(R.id.password)
    TextInputLayout password;
    @InjectView(R.id.switch_remember_me)
    Switch switchRememberMe;
    @InjectView(R.id.btn_go_next)
    Button btnGoNext;
    @InjectView(R.id.txt_username)
    TextInputEditText txtUsername;
    @InjectView(R.id.txt_password)
    TextInputEditText txtPassword;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        getSupportActionBar().hide();

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        txtUsername.setText(loginPreferences.getString("username", null));
        txtPassword.setText(loginPreferences.getString("password", null));

        btnGoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtUsername.getText().toString().isEmpty() && txtPassword.getText().toString().isEmpty())
                {
                    txtUsername.setError("Please Enter Username");
                    txtPassword.setError("Please Enter Password");
                }
                else if(txtUsername.getText().toString().isEmpty())
                {
                    txtUsername.setError("Please Enter Username");
                }
                else if(txtPassword.getText().toString().isEmpty())
                {
                    txtPassword.setError("Please Enter Password");
                }
                else if(txtUsername.getText().toString().equals("admin@gmail.com") && txtPassword.getText().toString().equals("admin123"))
                {
                    String username = txtUsername.getText().toString();
                    String password = txtPassword.getText().toString();
                    if(switchRememberMe.isChecked())
                    {
                        loginPrefsEditor.putString("username", username);
                        loginPrefsEditor.putString("password", password);
                        loginPrefsEditor.apply();

                        Intent mIntent = new Intent(LoginActivity.this, CustomerListActivity.class);
                        startActivity(mIntent);
                    }
                    else
                    {
                        loginPrefsEditor.clear();
                        loginPrefsEditor.apply();

                        Intent mIntent = new Intent(LoginActivity.this, CustomerListActivity.class);
                        startActivity(mIntent);
                    }
                }
                else
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                    alert.setCancelable(false);
                    alert.setTitle("Login Error");
                    alert.setMessage("Invalid User ID and Password");
                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }
            }
        });
    }
}
