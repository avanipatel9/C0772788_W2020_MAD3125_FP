package com.avanipatel9.c0772788_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;

public class ShowBillDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'> Bill Details </font>"));
    }
}
