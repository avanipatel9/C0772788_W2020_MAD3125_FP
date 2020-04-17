package com.avanipatel9.c0772788_w2020_mad3125_fp.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        Bill mBill = this.billArrayList.get(position);
        if(mBill.getBillID().contains("HYD"))
        {
            holder.imgBill.setImageResource(R.drawable.hydro1);
            holder.txtBillDate.setText(mBill.getBillDate().toString());
            holder.txtBillType.setText(mBill.getBillType().toString());
            holder.txtManufacturerName.setText("Agency Name");
            //holder.txtValManufacturerName.setText(mBill);
            holder.txtPlanName.setText("Units Consumed");
            //holder.txtValPlanName.setText(mBill.ge);
            holder.txtBillAmount.setText(String.format("%f", mBill.getBillAmount()));

            holder.ll5Bill.setVisibility(View.INVISIBLE);
            holder.ll6Bill.setVisibility(View.INVISIBLE);
            holder.ll7Bill.setVisibility(View.INVISIBLE);
        }

        else if(mBill.getBillID().contains("NET"))
        {
            holder.imgBill.setImageResource(R.drawable.wifi1);
            holder.ll5Bill.setVisibility(View.INVISIBLE);
            holder.ll6Bill.setVisibility(View.INVISIBLE);
            holder.ll7Bill.setVisibility(View.INVISIBLE);
        }

        else
        {
            holder.imgBill.setImageResource(R.drawable.mobile1);
        }


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BillViewHolder extends RecyclerView.ViewHolder {

        LinearLayout ll5Bill;
        LinearLayout ll6Bill;
        LinearLayout ll7Bill;
        TextView txtBillDate;
        TextView txtBillType;
        TextView txtManufacturerName;
        TextView txtValManufacturerName;
        TextView txtPlanName;
        TextView txtValPlanName;
        TextView txtMobileNumber;
        TextView txtInternetGBUsed;
        TextView txtMinutesUsed;
        TextView txtBillAmount;
        ImageView imgBill;

        public BillViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ll5Bill = itemView.findViewById(R.id.ll_5_bill);
            this.ll6Bill = itemView.findViewById(R.id.ll_6_bill);
            this.ll7Bill = itemView.findViewById(R.id.ll_7_bill);
            this.txtBillDate = itemView.findViewById(R.id.txt_val_bill_date);
            this.txtBillType = itemView.findViewById(R.id.txt_val_bill_type);
            this.txtManufacturerName = itemView.findViewById(R.id.txt_manufacturer_name);
            this.txtValManufacturerName = itemView.findViewById(R.id.txt_val_manufacturer_name);
            this.txtPlanName = itemView.findViewById(R.id.txt_plan_name);
            this.txtValPlanName = itemView.findViewById(R.id.txt_val_plan_name);
            this.txtMobileNumber = itemView.findViewById(R.id.txt_val_mobile_number);
            this.txtInternetGBUsed = itemView.findViewById(R.id.txt_val_mobile_gb_used);
            this.txtMinutesUsed = itemView.findViewById(R.id.txt_val_minutes_used);
            this.txtBillAmount = itemView.findViewById(R.id.txt_val_bill_amount);
            this.imgBill = itemView.findViewById(R.id.image_bill);
        }
    }
}
