package com.fmi.laborator6.interfaces;

public interface IStaticTest {

    static void staticMetod() {
        System.out.println("IStaticTest -> void staticMetod()");
    }

    default void defaultMethod() {
        System.out.println("IStaticTest -> void defaultMethod()");
    }
}
