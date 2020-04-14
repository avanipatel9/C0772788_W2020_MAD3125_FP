package com.avanipatel9.c0772788_w2020_mad3125_fp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Customer;

import org.w3c.dom.Text;

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
        holder.txtTotalBill.setText(String.valueOf(mCustomer.getTotalBillToPay()));
        holder.imgCustomer.setImageResource(R.drawable.login);
    }

    @Override
    public int getItemCount() {
        return this.customerArrayList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtCustomerName;
        TextView txtTotalBill;
        ImageView imgCustomer;


        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);

            this.txtCustomerName = itemView.findViewById(R.id.txt_customer_name);
            this.txtTotalBill = itemView.findViewById(R.id.txt_total_bill);
            this.imgCustomer = itemView.findViewById(R.id.img_customer);
        }
    }
}

