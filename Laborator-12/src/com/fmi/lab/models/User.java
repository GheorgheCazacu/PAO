package com.fmi.lab.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private Integer id;
    private String username;
    private String name;
    private Date dateOfBirth;
    private String cnp;

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MMM-dd");


    public User(Integer id, String username, String name, Date dateOfBirth, String cnp) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.cnp = cnp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + SIMPLE_DATE_FORMAT.format(dateOfBirth) +
                ", cnp='" + cnp + '\'' +
                '}';
    }
}
