package com.avanipatel9.c0772788_w2020_mad3125_fp.models;

import android.os.Parcel;

import java.util.Date;

public class Internet extends Bill {
    private String internetProviderName;
    private Double internetGBUsed;

    public Internet(String billID, Date billDate, BillType billType, String internetProviderName, Double internetGBUsed) {
        super(billID, billDate, billType);
        this.internetProviderName = internetProviderName;
        this.internetGBUsed = internetGBUsed;
        this.billAmount = calculateBill();
    }

    public String getInternetProviderName() {
        return internetProviderName;
    }

    public void setInternetProviderName(String internetProviderName) {
        this.internetProviderName = internetProviderName;
    }

    public Double getInternetGBUsed() {
        return internetGBUsed;
    }

    public void setInternetGBUsed(Double internetGBUsed) {
        this.internetGBUsed = internetGBUsed;
    }

    @Override
    public Double calculateBill() {
        this.billAmount = internetGBUsed * 3.5;
        return this.billAmount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.internetProviderName);
        dest.writeValue(this.internetGBUsed);
    }

    protected Internet(Parcel in) {
        super(in);
        this.internetProviderName = in.readString();
        this.internetGBUsed = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Creator<Internet> CREATOR = new Creator<Internet>() {
        @Override
        public Internet createFromParcel(Parcel source) {
            return new Internet(source);
        }

        @Override
        public Internet[] newArray(int size) {
            return new Internet[size];
        }
    };
}
