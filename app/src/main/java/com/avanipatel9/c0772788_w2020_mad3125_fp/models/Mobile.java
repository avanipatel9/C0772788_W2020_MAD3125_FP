package com.avanipatel9.c0772788_w2020_mad3125_fp.models;

import android.os.Parcel;

import java.util.Date;

public class Mobile extends Bill {

    private String mobileManufacturerName;
    private String planName;
    private String mobileNumber;
    private int mobileGBUsed;
    private int minutesUsed;

    public Mobile(String billID, Date billDate, BillType billType, String mobileManufacturerName, String planName, String mobileNumber, int mobileGBUsed, int minutesUsed) {
        super(billID, billDate, billType);
        this.mobileManufacturerName = mobileManufacturerName;
        this.planName = planName;
        this.mobileNumber = mobileNumber;
        this.mobileGBUsed = mobileGBUsed;
        this.minutesUsed = minutesUsed;
        this.billAmount = calculateBill();
    }

    public String getMobileManufacturerName() {
        return mobileManufacturerName;
    }

    public void setMobileManufacturerName(String mobileManufacturerName) {
        this.mobileManufacturerName = mobileManufacturerName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getMobileGBUsed() {
        return mobileGBUsed;
    }

    public void setMobileGBUsed(int mobileGBUsed) {
        this.mobileGBUsed = mobileGBUsed;
    }

    public int getMinutesUsed() {
        return minutesUsed;
    }

    public void setMinutesUsed(int minutesUsed) {
        this.minutesUsed = minutesUsed;
    }

    @Override
    public Double calculateBill() {
        this.billAmount = ((double) this.minutesUsed * 0.50) + ((double) this.mobileGBUsed * 7.5);
        return this.billAmount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.mobileManufacturerName);
        dest.writeString(this.planName);
        dest.writeString(this.mobileNumber);
        dest.writeInt(this.mobileGBUsed);
        dest.writeInt(this.minutesUsed);
    }

    protected Mobile(Parcel in) {
        super(in);
        this.mobileManufacturerName = in.readString();
        this.planName = in.readString();
        this.mobileNumber = in.readString();
        this.mobileGBUsed = in.readInt();
        this.minutesUsed = in.readInt();
    }

    public static final Creator<Mobile> CREATOR = new Creator<Mobile>() {
        @Override
        public Mobile createFromParcel(Parcel source) {
            return new Mobile(source);
        }

        @Override
        public Mobile[] newArray(int size) {
            return new Mobile[size];
        }
    };
}
