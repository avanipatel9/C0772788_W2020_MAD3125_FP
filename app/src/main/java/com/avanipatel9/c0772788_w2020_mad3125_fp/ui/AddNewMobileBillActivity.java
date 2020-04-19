package com.avanipatel9.c0772788_w2020_mad3125_fp.ui;

import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AppCompatActivity;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AddNewMobileBillActivity extends AppCompatActivity {


    @InjectView(R.id.edt_bill_id_mobile)
    TextInputEditText edtBillIdMobile;
    @InjectView(R.id.edt_bill_date_mobile)
    TextInputEditText edtBillDateMobile;
    @InjectView(R.id.edt_mobile_manufacturer_name)
    TextInputEditText edtMobileManufacturerName;
    @InjectView(R.id.edt_plan_name)
    TextInputEditText edtPlanName;
    @InjectView(R.id.edt_mobile_number)
    TextInputEditText edtMobileNumber;
    @InjectView(R.id.edt_mobile_gb_used)
    TextInputEditText edtMobileGbUsed;
    @InjectView(R.id.edt_minutes_used)
    TextInputEditText edtMinutesUsed;
    @InjectView(R.id.btn_save_new_mobile_bill)
    MaterialButton btnSaveNewMobileBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_mobile_bill);
        ButterKnife.inject(this);
        getSupportActionBar().setTitle(Html.fromHtml("<font color= '#FFFFFF'> Add Mobile Bill </font>"));
    }
}
