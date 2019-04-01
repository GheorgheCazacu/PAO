package com.fmi.laborator6.interfaces;

public class MyClass9 implements MyInterface9 {

    public void doStuffClass() {
        // static is not inherited
        MyInterface9.doStuffStatic();

        // default method it is
        doStuffDefault();

    }



}
