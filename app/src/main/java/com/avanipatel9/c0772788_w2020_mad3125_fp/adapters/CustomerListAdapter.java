package com.avanipatel9.c0772788_w2020_mad3125_fp.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Bill;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Customer;
import com.avanipatel9.c0772788_w2020_mad3125_fp.ui.ShowBillDetailsActivity;

import java.util.ArrayList;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.CustomerViewHolder> {

    ArrayList<Customer> customerArrayList;

    public CustomerListAdapter(ArrayList<Customer> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        CustomerViewHolder mCustomerViewHolder = new CustomerViewHolder(mView);
        return mCustomerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {

        Customer mCustomer = this.customerArrayList.get(position);
        holder.txtCustomerName.setText(mCustomer.getFullName());
        holder.txtEmail.setText(mCustomer.getEmailID());
        holder.txtTotalBill.setText(String.valueOf(mCustomer.getTotalBillToPay()));
        holder.imgCustomer.setImageResource(R.drawable.customers);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customer mCustomer = customerArrayList.get(position);
                ArrayList<Bill> bills = mCustomer.getBillsArray();
                Bundle bundle = new Bundle();
                bundle.putParcelable("customerKey", mCustomer);
                Intent mIntent = new Intent(holder.itemView.getContext(), ShowBillDetailsActivity.class);
                mIntent.putExtras(bundle);
                mIntent.putParcelableArrayListExtra("bills", (ArrayList<? extends Parcelable>) bills);
                holder.itemView.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.customerArrayList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtCustomerName;
        TextView txtTotalBill;
        TextView txtEmail;
        ImageView imgCustomer;


        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);

            this.txtCustomerName = itemView.findViewById(R.id.txt_customer_name);
            this.txtEmail = itemView.findViewById(R.id.txt_email);
            this.txtTotalBill = itemView.findViewById(R.id.txt_total_bill);
            this.imgCustomer = itemView.findViewById(R.id.img_customer);
        }
    }
}

