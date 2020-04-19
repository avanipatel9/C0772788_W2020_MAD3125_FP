package com.avanipatel9.c0772788_w2020_mad3125_fp.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.avanipatel9.c0772788_w2020_mad3125_fp.R;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Bill;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Hydro;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Internet;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Mobile;

import java.text.NumberFormat;
import java.util.ArrayList;

public class BillListAdapter extends RecyclerView.Adapter<BillListAdapter.BillViewHolder> {

    ArrayList<Bill> billArrayList;
    NumberFormat format = NumberFormat.getCurrencyInstance();

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
            holder.txtBillDate.setText(mHydro.getBillDate().toString());
            holder.txtBillType.setText(mHydro.getBillType().toString());
            holder.txtBillAmount.setText(format.format(mHydro.getBillAmount()));
            holder.txtAgencyName.setText(mHydro.getAgencyName());
            holder.txtUnitsConsumed.setText(String.format("%d units", mHydro.getUnitsConsumed()));

            holder.llMobile.setVisibility(View.INVISIBLE);
            holder.llInternet.setVisibility(View.INVISIBLE);

        }

        else if(mBill.getBillID().contains("NET"))
        {
            Internet mInternet = (Internet) mBill;
            holder.imgBill.setImageResource(R.drawable.wifi1);

            holder.txtBillDate.setText(mInternet.getBillDate().toString());
            holder.txtBillType.setText(mInternet.getBillType().toString());
            holder.txtBillAmount.setText(format.format(mInternet.getBillAmount()));
            holder.txtInternetProviderName.setText(mInternet.getInternetProviderName());
            holder.txtInternetGBUsed.setText(mInternet.getInternetGBUsed() + "GB");

            holder.llHydro.setVisibility(View.INVISIBLE);
            holder.llMobile.setVisibility(View.INVISIBLE);

        }

        else if(mBill.getBillID().contains("MOB"))
        {
            holder.imgBill.setImageResource(R.drawable.mobile1);
            Mobile mMobile = (Mobile) mBill;
            holder.txtBillDate.setText(mMobile.getBillDate().toString());
            holder.txtBillType.setText(mMobile.getBillType().toString());
            holder.txtBillAmount.setText(format.format(mMobile.getBillAmount()));
            holder.txtManufacturerName.setText(mMobile.getMobileManufacturerName());
            holder.txtPlanName.setText(mMobile.getPlanName());
            holder.txtMobileNumber.setText(mMobile.getMobileNumber());
            holder.txtMobileGBUsed.setText(mMobile.getMobileGBUsed() + "GB");
            holder.txtMinutesUsed.setText(mMobile.getMinutesUsed() + "Minutes");

            holder.llHydro.setVisibility(View.INVISIBLE);
            holder.llInternet.setVisibility(View.INVISIBLE);

        }
        else
        {
            holder.txtTotalBillToPay.setText("This Customer has no bills");
            holder.cardView.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return billArrayList.size();
    }

    public class BillViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        LinearLayout llHydro;
        LinearLayout llInternet;
        LinearLayout llMobile;

        TextView txtTotalBillToPay;
        TextView txtBillAmount;
        TextView txtBillDate;
        TextView txtBillType;
        TextView txtAgencyName;
        TextView txtUnitsConsumed;
        TextView txtInternetGBUsed;
        TextView txtInternetProviderName;
        TextView txtManufacturerName;
        TextView txtPlanName;
        TextView txtMobileNumber;
        TextView txtMobileGBUsed;
        TextView txtMinutesUsed;

        ImageView imgBill;

        public BillViewHolder(@NonNull View itemView) {
            super(itemView);

            this.cardView = itemView.findViewById(R.id.card_view);
            this.llHydro = itemView.findViewById(R.id.ll_bill_hydro);
            this.llInternet = itemView.findViewById(R.id.ll_bill_internet);
            this.llMobile = itemView.findViewById(R.id.ll_bill_Mobile);
            this.imgBill = itemView.findViewById(R.id.image_bill);
            this.txtBillAmount = itemView.findViewById(R.id.txt_val_bill_amount);
            this.txtBillDate = itemView.findViewById(R.id.txt_val_bill_date);
            this.txtBillType = itemView.findViewById(R.id.txt_val_bill_type);
            this.txtAgencyName = itemView.findViewById(R.id.txt_val_agency_name);
            this.txtUnitsConsumed = itemView.findViewById(R.id.txt_val_units_consumed);
            this.txtInternetProviderName = itemView.findViewById(R.id.txt_val_internet_provider);
            this.txtInternetGBUsed = itemView.findViewById(R.id.txt_val_internet_gb_used);
            this.txtManufacturerName = itemView.findViewById(R.id.txt_val_manufacturer_name);
            this.txtPlanName = itemView.findViewById(R.id.txt_val_plan_name);
            this.txtMobileNumber = itemView.findViewById(R.id.txt_val_mobile_number);
            this.txtMobileGBUsed = itemView.findViewById(R.id.txt_val_mobile_gb_used);
            this.txtMinutesUsed = itemView.findViewById(R.id.txt_val_minutes_used);

        }
    }
}
