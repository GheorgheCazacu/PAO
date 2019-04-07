package com.fmi.laborator07.models;

import java.util.Date;

public class Invoice {
    private String code;
    private Date date;
    private Item[] listOfItems;

    public Invoice(String code, Date date, Item[] listOfItems) {
        this.code = code;
        this.date = date;
        this.listOfItems = listOfItems;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Item[] getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(Item[] listOfItems) {
        this.listOfItems = listOfItems;
    }
}
