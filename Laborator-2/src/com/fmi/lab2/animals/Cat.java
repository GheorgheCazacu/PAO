package com.fmi.lab2.animals;

import java.util.Arrays;
import java.util.*;


public class Cat {

    protected boolean shortHair;

    private Integer size; // possible values 1, 2, 3  => small, medium, big - enum in the future

    Integer propDefault;

    public void meow() {
        System.out.println("cat - meow");
    }

    public void doStuff() {
        Arrays.toString(new Integer[]{1, 2, 3});
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

    public Integer getPropDefault() {
        return propDefault;
    }

    public void setPropDefault(Integer propDefault) {
        this.propDefault = propDefault;
    }

}
