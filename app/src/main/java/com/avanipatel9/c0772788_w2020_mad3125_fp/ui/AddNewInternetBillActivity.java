package com.avanipatel9.c0772788_w2020_mad3125_fp.ui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Bill;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Customer;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Hydro;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Internet;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy");

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

        btnSaveNewInternetBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtBillIdInternet.getText().toString().isEmpty() && edtBillDateInternet.getText().toString().isEmpty() && edtInternetProviderName.getText().toString().isEmpty() && edtInternetGbUsed.getText().toString().isEmpty())
                {
                    edtBillIdInternet.setError("Please Enter Bill ID");
                    edtBillDateInternet.setError("Please Enter Bill Date");
                    edtInternetProviderName.setError("Please Enter Internet Provider Name");
                    edtInternetGbUsed.setError("Please Enter Internet GB Used");
                }
                else if(edtBillIdInternet.getText().toString().isEmpty())
                {
                    edtBillIdInternet.setError("Please Enter Bill ID");
                }
                else if(!edtBillIdInternet.getText().toString().contains("NET"))
                {
                    edtBillIdInternet.setError("Bill ID should start with 'NET'");
                }
                else if(edtBillDateInternet.getText().toString().isEmpty())
                {
                    edtBillDateInternet.setError("Please Enter Bill Date");
                }
                else if(edtInternetProviderName.getText().toString().isEmpty())
                {
                    edtInternetProviderName.setError("Please Enter Internet Provider Name");
                }
                else if(edtInternetGbUsed.getText().toString().isEmpty())
                {
                    edtInternetGbUsed.setError("Please Enter Internet GB Used");
                }
                else
                {
                    Intent mIntent;
                    try {
                        Internet internet = new Internet(edtBillIdInternet.getText().toString(), sdf1.parse(edtBillDateInternet.getText().toString()), Bill.BillType.Internet, edtInternetProviderName.getText().toString(), Double.valueOf(edtInternetGbUsed.getText().toString()));
                        mIntent = getIntent();
                        customer = mIntent.getParcelableExtra("customerKey");
                        customer.addBill(internet, internet.getBillID());
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("customerKey", customer);
                        mIntent = new Intent(AddNewInternetBillActivity.this, ShowBillDetailsActivity.class);
                        mIntent.putExtras(bundle);
                        mIntent.putParcelableArrayListExtra("bills", customer.getBillsArray());
                        startActivity(mIntent);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
