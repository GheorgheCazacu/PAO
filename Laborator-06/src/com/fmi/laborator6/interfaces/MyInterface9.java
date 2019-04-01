package com.fmi.laborator6.interfaces;

public interface MyInterface9 {

    private void doStuffPrivate() {
        System.out.println("MyInterface9 -> doStuff()");
    }

    default void doStuffDefault() {
        System.out.println("MyInterface9 -> doOtherStuff()");
        doStuffPrivate();
    }

    // private

    private static void doStuffPrivateStatic() {
        System.out.println("MyInterface9 -> doStuff()");
    }

    static void doStuffStatic() {
        System.out.println("MyInterface9 -> doOtherStuff()");
        doStuffPrivateStatic();
    }
}
