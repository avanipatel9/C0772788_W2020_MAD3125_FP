package com.avanipatel9.c0772788_w2020_mad3125_fp.ui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Bill;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Customer;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Hydro;
import com.avanipatel9.c0772788_w2020_mad3125_fp.util.DataRepository;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AddNewHydroBillActivity extends AppCompatActivity {

    @InjectView(R.id.edt_bill_id_hydro)
    TextInputEditText edtBillIdHydro;
    @InjectView(R.id.edt_bill_date_hydro)
    TextInputEditText edtBillDateHydro;
    @InjectView(R.id.edt_agency_name)
    TextInputEditText edtAgencyName;
    @InjectView(R.id.edt_units_consumed)
    TextInputEditText edtUnitsConsumed;
    @InjectView(R.id.btn_save_new_hydro_bill)
    MaterialButton btnSaveNewHydroBill;
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
        setContentView(R.layout.activity_add_new_hydro_bill);
        ButterKnife.inject(this);

        getSupportActionBar().setTitle(Html.fromHtml("<font color= '#FFFFFF'> Add Hydro Bill </font>"));
        getSupportActionBar().setElevation(0);

        edtBillDateHydro.setInputType(InputType.TYPE_NULL);
        edtBillDateHydro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // date picker dialog
                picker = new DatePickerDialog(AddNewHydroBillActivity.this,
                        (view, year, monthOfYear, dayOfMonth) -> edtBillDateHydro.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year), year, month, day);
                picker.show();
            }
        });

        btnSaveNewHydroBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtBillIdHydro.getText().toString().isEmpty() && edtBillDateHydro.getText().toString().isEmpty() && edtAgencyName.getText().toString().isEmpty() && edtUnitsConsumed.getText().toString().isEmpty())
                {
                    edtBillIdHydro.setError("Please Enter Bill ID");
                    edtBillDateHydro.setError("Please Enter Bill Date");
                    edtAgencyName.setError("Please Enter Agency Name");
                    edtUnitsConsumed.setError("Please Enter Units consumed");
                }
                else if(edtBillIdHydro.getText().toString().isEmpty())
                {
                    edtBillIdHydro.setError("Please Enter Bill ID");
                }
                else if(!edtBillIdHydro.getText().toString().contains("HYD"))
                {
                    edtBillIdHydro.setError("Bill ID should start with HYD");
                }
                else if(edtBillDateHydro.getText().toString().isEmpty())
                {
                    edtBillDateHydro.setError("Please Enter Bill Date");
                }
                else if(edtAgencyName.getText().toString().isEmpty())
                {
                    edtAgencyName.setError("Please Enter Agency Name");
                }
                else if(edtUnitsConsumed.getText().toString().isEmpty())
                {
                    edtUnitsConsumed.setError("Please Enter Units consumed");
                }
                else
                {
                    Intent mIntent;
                    try {
                        Hydro hydro = new Hydro(edtBillIdHydro.getText().toString(), sdf1.parse(edtBillDateHydro.getText().toString()), Bill.BillType.Hydro, edtAgencyName.getText().toString(), Integer.parseInt(edtUnitsConsumed.getText().toString()));
                        mIntent = getIntent();
                        customer = mIntent.getParcelableExtra("customerKey");
                        customer.addBill(hydro, hydro.getBillID());
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("customerKey", customer);
                        mIntent = new Intent(AddNewHydroBillActivity.this, ShowBillDetailsActivity.class);
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
