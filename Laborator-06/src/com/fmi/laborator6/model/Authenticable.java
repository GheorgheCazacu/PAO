package com.fmi.laborator6.model;

public interface Authenticable {

    default void performAuthentication() throws Exception {
        System.out.println("Authenticable - > performAuthentication()");
        doStuff();
    }

    private void doStuff() {
        System.out.println("Authenticable -> doStuff()");
    }
}
