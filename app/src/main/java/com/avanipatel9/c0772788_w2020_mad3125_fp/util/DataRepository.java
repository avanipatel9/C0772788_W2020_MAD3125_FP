package com.avanipatel9.c0772788_w2020_mad3125_fp.util;

import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Bill;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Customer;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Hydro;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Internet;
import com.avanipatel9.c0772788_w2020_mad3125_fp.models.Mobile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;

public class DataRepository {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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

    public void loadData() throws ParseException {

        Hydro h1 = new Hydro("HYD001", sdf.parse("2019-04-01"), Bill.BillType.Hydro, "Planet Energy", 29);
        Hydro h2 = new Hydro("HYD002", sdf.parse("2019-10-12"), Bill.BillType.Hydro, "Planet Energy", 50);
        Hydro h3 = new Hydro("HYD003", sdf.parse("2018-04-21"), Bill.BillType.Hydro, "Planet Energy", 60);

        Internet i1 = new Internet("NET001", sdf.parse("2018-07-29"), Bill.BillType.Internet, "Bell", 500.0);
        Internet i2 = new Internet("NET002", sdf.parse("2018-12-17"), Bill.BillType.Internet, "Roger", 300.0);
        Internet i3 = new Internet("NET003", sdf.parse("2020-01-31"), Bill.BillType.Internet, "Roger", 250.0);

        Customer c1 = new Customer("C001", "Charmi", "Patel", "charmi@gmail.com");
        c1.addBill(h1, h1.getBillID());
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
