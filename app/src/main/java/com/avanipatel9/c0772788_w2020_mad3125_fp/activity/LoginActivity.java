package com.avanipatel9.c0772788_w2020_mad3125_fp.activity;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity {

    @InjectView(R.id.edt_email)
    TextInputEditText edtEmail;
    @InjectView(R.id.txt_email)
    TextInputLayout txtEmail;
    @InjectView(R.id.edt_password)
    TextInputEditText edtPassword;
    @InjectView(R.id.txt_password)
    TextInputLayout txtPassword;
    @InjectView(R.id.switchRememberMe)
    SwitchMaterial switchRememberMe;
    @InjectView(R.id.btn_go_next)
    MaterialButton btnGoNext;

    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
    }
}
