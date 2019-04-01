package com.fmi.laborator6.model;

public interface AuthenticableDB extends Authenticable{

    private void performDBAuth() {
        System.out.println("AuthenticableDB -> performDBAuth()");
    }

    @Override
    default void performAuthentication() throws Exception{
        System.out.println("AuthenticableDB -> performAuthentication()");
    }
}
