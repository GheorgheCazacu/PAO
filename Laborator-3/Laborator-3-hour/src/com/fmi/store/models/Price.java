package com.fmi.store.models;

import java.util.Date;

public class Price {

    private Double price;
    private Date startFrom;
    private Date endFrom;

    public Price(Double price, Date startFrom, Date endFrom) {
        this.price = price;
        this.startFrom = startFrom;
        this.endFrom = endFrom;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getStartFrom() {
        return startFrom;
    }

    public void setStartFrom(Date startFrom) {
        this.startFrom = startFrom;
    }

    public Date getEndFrom() {
        return endFrom;
    }

    public void setEndFrom(Date endFrom) {
        this.endFrom = endFrom;
    }
}
