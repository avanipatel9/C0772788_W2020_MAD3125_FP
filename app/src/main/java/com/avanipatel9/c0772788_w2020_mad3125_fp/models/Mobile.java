package com.avanipatel9.c0772788_w2020_mad3125_fp.models;

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
        return null;
    }
}
