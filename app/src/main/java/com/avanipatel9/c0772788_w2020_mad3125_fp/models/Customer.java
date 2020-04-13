package com.avanipatel9.c0772788_w2020_mad3125_fp.models;

import java.util.Dictionary;
import java.util.HashMap;

public class Customer {
    private String customerID;
    private String firstName;
    private String lastName;
    private String fullName;
    private String emailID;
    private Dictionary<String, Bill> billDictionary;

    public Customer(String customerID, String firstName, String lastName, String fullName, String emailID) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.emailID = emailID;
    }
}
