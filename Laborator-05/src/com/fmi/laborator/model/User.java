package com.fmi.laborator.model;

import com.fmi.laborator.auth.Authenticable;

import java.util.Date;

public class User  implements Authenticable {
    private String lastName;
    private String firstName;
    private Date dateOfBirth;

    private String userName;
    private String hashPassword;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getToken() {
        return Authenticable.DEFAULT_TOKEN;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getHashPassword() {
        return hashPassword;
    }
    @Override
    public String toString() {
        return "User{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
