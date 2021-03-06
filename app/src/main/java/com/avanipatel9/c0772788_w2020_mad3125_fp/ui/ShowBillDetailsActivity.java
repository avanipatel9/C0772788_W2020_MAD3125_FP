package com.avanipatel9.c0772788_w2020_mad3125_fp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.avanipatel9.c0772788_w2020_mad3125_fp.adapters.BillListAdapter;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Bill;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Customer;
import com.avanipatel9.c0772788_w2020_mad3125_fp.util.DataRepository;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class ShowBillDetailsActivity extends AppCompatActivity {

    private RecyclerView rvBillList;
    private Customer customer;
    private ArrayList<Bill> billArrayList;
    private BillListAdapter billListAdapter;
    private TextView txtTotalBillToPay;

    NumberFormat format = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'> Bill Details </font>"));
        getSupportActionBar().setElevation(0);

        DataRepository dataRepository = DataRepository.getInstance();
        try {
            dataRepository.loadData();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Intent intent = getIntent();
        customer = intent.getParcelableExtra("customerKey");
        billArrayList = intent.getParcelableArrayListExtra("bills");
        rvBillList = findViewById(R.id.rv_bill_list);
        billListAdapter = new BillListAdapter(billArrayList);

        txtTotalBillToPay = findViewById(R.id.txt_val_total_bill_to_pay);

        if(!billArrayList.isEmpty())
        {
            txtTotalBillToPay.setText("Total Bill To Pay : "+ format.format(customer.getTotalBillToPay()));
        }
        else
        {
            txtTotalBillToPay.setText("This Customer has No Bills");
        }

        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvBillList.setLayoutManager(mLinearLayoutManager);

        rvBillList.setAdapter(billListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bill_details, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent mIntent;
        Bundle bundle = new Bundle();
        bundle.putParcelable("customerKey", customer);
        switch (item.getItemId())
        {
            case R.id.btn_add_new_hydro_bill:
                mIntent = new Intent(ShowBillDetailsActivity.this, AddNewHydroBillActivity.class);
                mIntent.putExtras(bundle);
                startActivity(mIntent);
                break;
            case R.id.btn_add_new_internet_bill:
                mIntent = new Intent(ShowBillDetailsActivity.this, AddNewInternetBillActivity.class);
                mIntent.putExtras(bundle);
                startActivity(mIntent);
                break;
            case R.id.btn_add_new_mobile_bill:
                mIntent = new Intent(ShowBillDetailsActivity.this, AddNewMobileBillActivity.class);
                mIntent.putExtras(bundle);
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
