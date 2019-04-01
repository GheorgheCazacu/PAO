package com.fmi.laborator6.interfaces;


public class MainTestStatic {

    public static void main(String[] args) {
        // this is not working
        //StaticTestImpl.staticMetod();
        StaticTestImpl.fromClassStaticMetod();


        StaticTestImpl staticTest = new StaticTestImpl();
        staticTest.defaultMethod();


    }
}
