package com.avanipatel9.c0772788_w2020_mad3125_fp.util;

import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;

public class DataRepository {

    private static DataRepository dataRepository = new DataRepository();
    public static DataRepository getInstance(){

        return dataRepository;
    }

    private DataRepository(){ }

    private HashMap<String, Customer> customerHashMap = new HashMap<>();

    public HashMap<String, Customer> getCustomerHashMap() {
        return this.customerHashMap;
    }

    public ArrayList<Customer> getAllCustomers()
    {
        Collection<Customer> tempCustomerList = customerHashMap.values();
        return new ArrayList<>(tempCustomerList);
    }

    public void addCustomer(Customer customer)
    {
        this.customerHashMap.put(customer.getCustomerID(), customer);
    }

    public void loadData()
    {
        Customer c1 = new Customer("C001", "Charmi", "Patel", "charmi@gmail.com");
        Customer c2 = new Customer("C002", "Jyothi", "Thomas", "jyothi@gmail.com");
        Customer c3 = new Customer("C003", "Shreya", "Vaghasiya", "shreya@gmail.com");
        Customer c4 = new Customer("C004", "Kashyap", "Zaveri", "kashyap@gmail.com");
        Customer c5 = new Customer("C005", "Monika", "Sharma", "monika@gmail.com");

        customerHashMap.put(c1.getCustomerID(), c1);
        customerHashMap.put(c2.getCustomerID(), c2);
        customerHashMap.put(c3.getCustomerID(), c3);
        customerHashMap.put(c4.getCustomerID(), c4);
        customerHashMap.put(c5.getCustomerID(), c5);
    }
}
