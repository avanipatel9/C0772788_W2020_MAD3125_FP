package com.avanipatel9.c0772788_w2020_mad3125_fp.models;

import java.util.Dictionary;

public class Customer {
    private String customerID;
    private String firstName;
    private String lastName;
    private String fullName;
    private String emailID;
    private Dictionary<String, Bill> billDictionary;
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

    public Dictionary<String, Bill> getBillDictionary() {
        return billDictionary;
    }

    public void setBillDictionary(Dictionary<String, Bill> billDictionary) {
        this.billDictionary = billDictionary;
    }

    public Double getTotalBillToPay() {
        return totalBillToPay;
    }

    public void addBill(Bill bill, String billId)
    {
        billDictionary.put(billId, bill);
        this.totalBillToPay = this.totalBillToPay + bill.billAmount;
    }

    public void removeBill(Bill bill, String billID)
    {
        billDictionary.remove(billID);
        System.out.println("Bill removed with ID " + billID);
    }
}
