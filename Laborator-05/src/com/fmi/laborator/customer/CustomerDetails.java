package com.fmi.laborator.customer;

import java.util.Date;

public class CustomerDetails {
    private String location;
    private String cnp;
    private Date dateOfBirth;

    public CustomerDetails(String location, String cnp, Date dateOfBirth) {
        this.location = location;
        this.cnp = cnp;
        this.dateOfBirth = dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
