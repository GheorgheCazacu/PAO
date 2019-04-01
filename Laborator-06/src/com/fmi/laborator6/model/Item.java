package com.fmi.laborator6.model;

public interface Item {

    Double TVA = 19d;

    Double getPrice();

    default Double getPriceWithTVA() {
        return getPrice() * (1.0 + (TVA/100.0));
    }

}
