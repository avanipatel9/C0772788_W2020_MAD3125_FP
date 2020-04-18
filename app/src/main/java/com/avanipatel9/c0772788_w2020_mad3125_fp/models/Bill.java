package com.avanipatel9.c0772788_w2020_mad3125_fp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public abstract class Bill implements Parcelable {

    public enum BillType{
        Mobile,
        Hydro,
        Internet
    }
    String billID;
    Date billDate;
    BillType billType;
    double billAmount;

    public Bill(String billID, Date billDate, BillType billType) {
        this.billID = billID;
        this.billDate = billDate;
        this.billType = billType;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public BillType getBillType() {
        return billType;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public abstract Double calculateBill();

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.billID);
        dest.writeLong(this.billDate != null ? this.billDate.getTime() : -1);
        dest.writeInt(this.billType == null ? -1 : this.billType.ordinal());
        dest.writeDouble(this.billAmount);
    }

    protected Bill(Parcel in) {
        this.billID = in.readString();
        long tmpBillDate = in.readLong();
        this.billDate = tmpBillDate == -1 ? null : new Date(tmpBillDate);
        int tmpBillType = in.readInt();
        this.billType = tmpBillType == -1 ? null : BillType.values()[tmpBillType];
        this.billAmount = in.readDouble();
    }

}
