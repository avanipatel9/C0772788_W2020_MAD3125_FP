package com.avanipatel9.c0772788_w2020_mad3125_fp.ui;

import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AppCompatActivity;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Customer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AddNewInternetBillActivity extends AppCompatActivity {

    @InjectView(R.id.edt_bill_id_internet)
    TextInputEditText edtBillIdInternet;
    @InjectView(R.id.edt_bill_date_internet)
    TextInputEditText edtBillDateInternet;
    @InjectView(R.id.edt_internet_provider_name)
    TextInputEditText edtInternetProviderName;
    @InjectView(R.id.edt_internet_gb_used)
    TextInputEditText edtInternetGbUsed;
    @InjectView(R.id.btn_save_new_internet_bill)
    MaterialButton btnSaveNewInternetBill;

    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_internet_bill);
        ButterKnife.inject(this);
        getSupportActionBar().setTitle(Html.fromHtml("<font color= '#FFFFFF'> Add Internet Bill </font>"));
    }
}
