package com.avanipatel9.c0772788_w2020_mad3125_fp.models;

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
}
