package com.avanipatel9.c0772788_w2020_mad3125_fp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.avanipatel9.c0772788_w2020_mad3125_fp.adapters.CustomerListAdapter;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Customer;
import com.avanipatel9.c0772788_w2020_mad3125_fp.util.DataRepository;

import java.util.ArrayList;

public class CustomerListActivity extends AppCompatActivity {

    private RecyclerView rvCustomerList;
    private ArrayList<Customer> customers;
    private CustomerListAdapter customerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        getSupportActionBar().setTitle("List of Customers");

        DataRepository dataRepository = DataRepository.getInstance();
        dataRepository.loadData();
        customers = dataRepository.getAllCustomers();

        rvCustomerList = findViewById(R.id.rv_customer_list);
        customerListAdapter = new CustomerListAdapter(customers);
        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvCustomerList.setLayoutManager(mLinearLayoutManager);

        rvCustomerList.setAdapter(customerListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_customer_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.btn_add_new_customer:
                Intent mIntent = new Intent(CustomerListActivity.this, AddNewCustomerActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_logout:
                Intent logout = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(logout);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
