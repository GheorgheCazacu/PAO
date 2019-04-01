package com.fmi.laborator6.model;

public interface AuthenticableLDAP extends Authenticable {

    private void performLDAPAuth() {
        System.out.println("AuthenticableLDAP -> performLDAPAuth()");
    }

    @Override
    default void performAuthentication() throws Exception {
        System.out.println("AuthenticableLDAP -> performAuthentication()");
    }

}
