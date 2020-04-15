package com.avanipatel9.c0772788_w2020_mad3125_fp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Customer;
import com.avanipatel9.c0772788_w2020_mad3125_fp.util.DataRepository;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AddNewCustomerActivity extends AppCompatActivity {

    @InjectView(R.id.edt_customer_id)
    TextInputEditText edtCustomerId;
    @InjectView(R.id.customer_id)
    TextInputLayout customerId;
    @InjectView(R.id.edt_first_name)
    TextInputEditText edtFirstName;
    @InjectView(R.id.first_name)
    TextInputLayout firstName;
    @InjectView(R.id.edt_last_name)
    TextInputEditText edtLastName;
    @InjectView(R.id.last_name)
    TextInputLayout lastName;
    @InjectView(R.id.edt_email)
    TextInputEditText edtEmail;
    @InjectView(R.id.email)
    TextInputLayout email;
    @InjectView(R.id.btn_save_customer)
    MaterialButton btnSaveCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);
        ButterKnife.inject(this);

        btnSaveCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtCustomerId.getText().toString().isEmpty() && edtFirstName.getText().toString().isEmpty() && edtLastName.getText().toString().isEmpty() && edtEmail.getText().toString().isEmpty())
                {
                    edtCustomerId.setError("Please Enter Customer ID");
                    edtFirstName.setError("Please Enter First Name");
                    edtLastName.setError("Please Enter Last Name");
                    edtEmail.setError("Please Enter Email ID");
                }
                else if (edtCustomerId.getText().toString().isEmpty())
                {
                    edtCustomerId.setError("Please Enter Customer ID");
                }
                else if(edtFirstName.getText().toString().isEmpty())
                {
                    edtFirstName.setError("Please Enter First Name");
                }
                else if (edtLastName.getText().toString().isEmpty())
                {
                    edtLastName.setError("Please Enter Last Name");
                }
                else if(edtEmail.getText().toString().isEmpty())
                {
                    edtEmail.setError("Please Enter Email ID");
                }
                else
                {
                    Customer newCustomer = new Customer(edtCustomerId.getText().toString(), edtFirstName.getText().toString(), edtLastName.getText().toString(), edtEmail.getText().toString());
                    DataRepository.getInstance().addCustomer(newCustomer);
                    Intent newCustomerIntent = new Intent(AddNewCustomerActivity.this, CustomerListActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("newCustomer", newCustomer);
                    newCustomerIntent.putExtras(bundle);
                    startActivity(newCustomerIntent);
                }
            }
        });
    }
}
