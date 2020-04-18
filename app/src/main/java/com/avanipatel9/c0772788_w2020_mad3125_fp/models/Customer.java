package com.avanipatel9.c0772788_w2020_mad3125_fp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;

public class Customer implements Parcelable {
    private String customerID;
    private String firstName;
    private String lastName;
    private String fullName;
    private String emailID;
    private HashMap<String, Bill> billHashMap = new HashMap<String, Bill>();
    private ArrayList<Bill> billArrayList;
    private Double totalBillToPay = 0.0;

    public Customer(String customerID, String firstName, String lastName, String emailID) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public HashMap<String, Bill> getBillHashMap() {
        return billHashMap;
    }

    public void setBillHashMap(HashMap<String, Bill> billHashMap) {
        this.billHashMap = billHashMap;
    }


    public Double getTotalBillToPay() {
        return totalBillToPay;
    }

    public void addBill(Bill bill, String billId)
    {
        billHashMap.put(billId, bill);
        this.totalBillToPay = this.totalBillToPay + bill.billAmount;
    }

    public void removeBill(Bill bill, String billID)
    {
        billHashMap.remove(billID);
        System.out.println("Bill removed with ID " + billID);
    }

    public ArrayList<Bill> getBillsArray()
    {
        Collection<Bill> tempBills = billHashMap.values();
        this.billArrayList = new ArrayList<>(tempBills);
        return billArrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.customerID);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.fullName);
        dest.writeString(this.emailID);
        dest.writeMap(this.billHashMap);
        dest.writeArray(new ArrayList[]{this.billArrayList});
        dest.writeValue(this.totalBillToPay);
    }

    protected Customer(Parcel in) {
        this.customerID = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.fullName = in.readString();
        this.emailID = in.readString();
        this.billHashMap = in.readHashMap(Bill.class.getClassLoader());
        this.billArrayList = in.readArrayList(Bill.class.getClassLoader());
        this.totalBillToPay = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel source) {
            return new Customer(source);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };
}
