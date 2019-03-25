package com.fmi.laborator.customer;

import com.fmi.laborator.model.User;

public class Customer extends User {

    private CustomerDetails customerDetails;

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }
}
