package com.avanipatel9.c0772788_w2020_mad3125_fp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Bill;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Customer;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Hydro;
import com.avanipatel9.c0772788_w2020_mad3125_fp.util.DataRepository;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AddNewHydroBillActivity extends AppCompatActivity {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

    @InjectView(R.id.edt_bill_id_hydro)
    TextInputEditText edtBillIdHydro;
    @InjectView(R.id.bill_id_hydro)
    TextInputLayout billIdHydro;
    @InjectView(R.id.edt_bill_date_hydro)
    TextInputEditText edtBillDateHydro;
    @InjectView(R.id.bill_date_hydro)
    TextInputLayout billDateHydro;
    @InjectView(R.id.edt_agency_name)
    TextInputEditText edtAgencyName;
    @InjectView(R.id.agency_name)
    TextInputLayout agencyName;
    @InjectView(R.id.edt_units_consumed)
    TextInputEditText edtUnitsConsumed;
    @InjectView(R.id.units_consumed)
    TextInputLayout unitsConsumed;
    @InjectView(R.id.btn_save_new_hydro_bill)
    MaterialButton btnSaveNewHydroBill;
    Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_hydro_bill);
        ButterKnife.inject(this);

        getSupportActionBar().setTitle(Html.fromHtml("<font color= '#FFFFFF'> Add Hydro Bill </font>"));

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
                        Hydro hydro = new Hydro(edtBillIdHydro.getText().toString(), sdf.parse(edtBillDateHydro.getText().toString()), Bill.BillType.Hydro, edtAgencyName.getText().toString(), Integer.parseInt(edtUnitsConsumed.getText().toString()));
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
