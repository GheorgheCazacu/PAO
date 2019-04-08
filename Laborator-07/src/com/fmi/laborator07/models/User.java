package com.fmi.laborator07.models;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String name;
    private Date dateOfBirth;
    private String hashPassword;

    public User(String name, Date dateOfBirth, String hashPassword) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.hashPassword = hashPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", hashPassword='" + hashPassword + '\'' +
                '}';
    }
}
