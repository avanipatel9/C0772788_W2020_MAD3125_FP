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
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Hydro;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Internet;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Mobile;

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
            Hydro mHydro = (Hydro) mBill;
            holder.imgBill.setImageResource(R.drawable.hydro1);
            holder.txtBillDate.setText(mBill.getBillDate().toString());
            holder.txtBillType.setText(mBill.getBillType().toString());
            holder.txtManufacturerName.setText("Agency Name");
            holder.txtValManufacturerName.setText((mHydro.getAgencyName()));
            holder.txtPlanName.setText("Units Consumed");
            holder.txtValPlanName.setText(String.valueOf(mHydro.getUnitsConsumed()));
            holder.txtBillAmount.setText(String.format("%2f", mBill.getBillAmount()));

            holder.ll5Bill.setVisibility(View.INVISIBLE);
            holder.ll6Bill.setVisibility(View.INVISIBLE);
            holder.ll7Bill.setVisibility(View.INVISIBLE);
        }

        else if(mBill.getBillID().contains("NET"))
        {
            Internet mInternet = (Internet) mBill;
            holder.imgBill.setImageResource(R.drawable.wifi1);
            holder.ll5Bill.setVisibility(View.INVISIBLE);
            holder.ll6Bill.setVisibility(View.INVISIBLE);
            holder.ll7Bill.setVisibility(View.INVISIBLE);
            holder.txtBillDate.setText(mInternet.getBillDate().toString());
            holder.txtBillType.setText(mInternet.getBillType().toString());
            holder.txtManufacturerName.setText("Internet Provider Name");
            holder.txtValManufacturerName.setText(mInternet.getInternetProviderName());
            holder.txtPlanName.setText("Internet GB Used");
            holder.txtValPlanName.setText(String.valueOf(mInternet.getInternetGBUsed()));
            holder.txtBillAmount.setText(String.format("%2f", mInternet.getBillAmount()));
        }

        else
        {
            holder.imgBill.setImageResource(R.drawable.mobile1);
            Mobile mMobile = (Mobile) mBill;
            holder.txtBillDate.setText(mMobile.getBillDate().toString());
            holder.txtBillType.setText(mMobile.getBillType().toString());
            holder.txtManufacturerName.setText("Manufacturer Name");
            holder.txtValManufacturerName.setText(mMobile.getMobileManufacturerName());
            holder.txtPlanName.setText("Plan Name");
            holder.txtValPlanName.setText(mMobile.getPlanName());
            holder.txtMobileNumber.setText(mMobile.getMobileNumber());
            holder.txtInternetGBUsed.setText(String.valueOf(mMobile.getMobileGBUsed()));
            holder.txtMinutesUsed.setText(String.valueOf(mMobile.getMinutesUsed()));
            holder.txtBillAmount.setText(String.format("%2f", mMobile.getBillAmount()));
        }


    }

    @Override
    public int getItemCount() {
        return billArrayList.size();
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
