package com.avanipatel9.c0772788_w2020_mad3125_fp.models;

import java.util.Date;

public abstract class Bill {

    public enum BillType{
        Mobile,
        Hydro,
        Internet
    }
    String billID;
    Date billDate;
    BillType billType;
    double totalBillAmount;
}
