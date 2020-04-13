package com.avanipatel9.c0772788_w2020_mad3125_fp.models;

import java.util.Date;

public class Hydro extends Bill {

   private String agencyName;
   private int unitsConsumed;

    public Hydro(String billID, Date billDate, BillType billType, String agencyName, int unitsConsumed) {
        super(billID, billDate, billType);
        this.agencyName = agencyName;
        this.unitsConsumed = unitsConsumed;
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
        return null;
    }
}
