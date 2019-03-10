package com.fmi.lab2.animals;

public class Dog {

    private boolean shortHair;

    private Integer size; // possible values 1, 2, 3  => small, medium, big - enum in the future

    Integer propDefault;

    public void bark() {
        System.out.println("dog-bark");
    }


    public boolean isShortHair() {
        return shortHair;
    }

    public void setShortHair(boolean shortHair) {
        this.shortHair = shortHair;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
