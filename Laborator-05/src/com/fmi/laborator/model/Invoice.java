package com.fmi.laborator.model;

import com.fmi.laborator.customer.Customer;

import java.util.Date;

public class Invoice {

    private Date date;
    private Customer customer;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
