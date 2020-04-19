package com.avanipatel9.c0772788_w2020_mad3125_fp.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Customer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    Customer customer;

    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");

    private DatePickerDialog picker;
    final Calendar calendar = Calendar.getInstance();
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final int month = calendar.get(Calendar.MONTH);
    final int year = calendar.get(Calendar.YEAR);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_mobile_bill);
        ButterKnife.inject(this);
        getSupportActionBar().setTitle(Html.fromHtml("<font color= '#FFFFFF'> Add Mobile Bill </font>"));

        edtBillDateMobile.setInputType(InputType.TYPE_NULL);
        edtBillDateMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // date picker dialog
                picker = new DatePickerDialog(AddNewMobileBillActivity.this,
                        (view, year, monthOfYear, dayOfMonth) -> edtBillDateMobile.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year), year, month, day);
                picker.show();
            }
        });
    }
}
