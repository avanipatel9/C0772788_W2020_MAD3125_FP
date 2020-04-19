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

import java.util.Calendar;

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

    private DatePickerDialog picker;
    final Calendar calendar = Calendar.getInstance();
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final int month = calendar.get(Calendar.MONTH);
    final int year = calendar.get(Calendar.YEAR);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_internet_bill);
        ButterKnife.inject(this);
        getSupportActionBar().setTitle(Html.fromHtml("<font color= '#FFFFFF'> Add Internet Bill </font>"));

        edtBillDateInternet.setInputType(InputType.TYPE_NULL);
        edtBillDateInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // date picker dialog
                picker = new DatePickerDialog(AddNewInternetBillActivity.this,
                        (view, year, monthOfYear, dayOfMonth) -> edtBillDateInternet.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year), year, month, day);
                picker.show();
            }
        });
    }
}
