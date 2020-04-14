package com.avanipatel9.c0772788_w2020_mad3125_fp.util;

import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Customer;

import java.util.Dictionary;

public class DataRepository {

    private static DataRepository dataRepository = new DataRepository();
    public static DataRepository getInstance(){

        return dataRepository;
    }

    private DataRepository(){ }

    private Dictionary<String, Customer> customerDictionary;

    public Dictionary<String, Customer> getCustomerDictionary() {
        return this.customerDictionary;
    }

    public void loadData()
    {
        Customer c1 = new Customer("C001", "Charmi", "Patel", "charmi@gmail.com");
        Customer c2 = new Customer("C002", "Jyothi", "Thomas", "jyothi@gmail.com");
        Customer c3 = new Customer("C003", "Shreya", "Vaghasiya", "shreya@gmail.com");
        Customer c4 = new Customer("C004", "Kashyap", "Zaveri", "kashyap@gmail.com");
        Customer c5 = new Customer("C005", "Monika", "Sharma", "monika@gmail.com");

        customerDictionary.put(c1.getCustomerID(), c1);
        customerDictionary.put(c2.getCustomerID(), c2);
        customerDictionary.put(c3.getCustomerID(), c3);
        customerDictionary.put(c4.getCustomerID(), c4);
        customerDictionary.put(c5.getCustomerID(), c5);
    }
}
