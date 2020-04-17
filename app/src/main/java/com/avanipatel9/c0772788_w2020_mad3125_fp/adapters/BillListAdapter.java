package com.avanipatel9.c0772788_w2020_mad3125_fp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Bill;

import java.util.ArrayList;

public class BillListAdapter extends RecyclerView.Adapter<BillListAdapter.BillViewHolder> {

    ArrayList<Bill> billArrayList;

    public BillListAdapter(ArrayList<Bill> billArrayList) {
        this.billArrayList = billArrayList;
    }

    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bill, parent, false);
        BillViewHolder mBillViewHolder = new BillViewHolder(mView);
        return mBillViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BillViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BillViewHolder extends RecyclerView.ViewHolder {

        TextView txtBillDate;
        TextView txtBillType;
        TextView txtManufacturerName;
        TextView txtPlanName;
        TextView txtMobileNumber;
        TextView txtInternetGBUsed;
        TextView txtMinutesUsed;
        TextView txtBillAmount;
        ImageView imgBill;

        public BillViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtBillDate = itemView.findViewById(R.id.txt_val_bill_date);
            this.txtBillType = itemView.findViewById(R.id.txt_val_bill_type);
            this.txtManufacturerName = itemView.findViewById(R.id.txt_val_manufacturer_name);
            this.txtPlanName = itemView.findViewById(R.id.txt_val_plan_name);
            this.txtMobileNumber = itemView.findViewById(R.id.txt_val_mobile_number);
            this.txtInternetGBUsed = itemView.findViewById(R.id.txt_val_mobile_gb_used);
            this.txtMinutesUsed = itemView.findViewById(R.id.txt_val_minutes_used);
            this.txtBillAmount = itemView.findViewById(R.id.txt_val_bill_amount);
            this.imgBill = itemView.findViewById(R.id.image_bill);
        }
    }
}
