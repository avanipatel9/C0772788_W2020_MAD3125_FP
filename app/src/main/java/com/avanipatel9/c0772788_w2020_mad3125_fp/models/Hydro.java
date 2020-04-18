package com.avanipatel9.c0772788_w2020_mad3125_fp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Hydro extends Bill {

   private String agencyName;
   private int unitsConsumed;

    public Hydro(String billID, Date billDate, BillType billType, String agencyName, int unitsConsumed) {
        super(billID, billDate, billType);
        this.agencyName = agencyName;
        this.unitsConsumed = unitsConsumed;
        this.billAmount = calculateBill();
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(int unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }

    @Override
    public Double calculateBill() {
        this.billAmount = (double) unitsConsumed * 20.0;
        return this.billAmount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.agencyName);
        dest.writeInt(this.unitsConsumed);
    }

    protected Hydro(Parcel in) {
        super(in);
        this.agencyName = in.readString();
        this.unitsConsumed = in.readInt();
    }

    public static final Creator<Hydro> CREATOR = new Creator<Hydro>() {
        @Override
        public Hydro createFromParcel(Parcel source) {
            return new Hydro(source);
        }

        @Override
        public Hydro[] newArray(int size) {
            return new Hydro[size];
        }
    };
}
