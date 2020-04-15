package com.avanipatel9.c0772788_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;

public class AddNewHydroBillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_hydro_bill);

        getSupportActionBar().setTitle(Html.fromHtml("<font color= '#FFFFFF'> Add Hydro Bill </font>"));
    }
}
