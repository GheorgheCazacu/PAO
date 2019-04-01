package com.fmi.laborator6.model;

import com.fmi.laborator6.exceptions.UserAuthException;

public class User implements AuthenticableDB, AuthenticableLDAP{

    private String name;
    private String hashPass;

    public enum AuthType {
        DB, LDAP;
    }

    private AuthType authType;

    public User(String name, String hashPass, AuthType authType) {
        this.name = name;
        this.hashPass = hashPass;
        this.authType = authType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    public AuthType getAuthType() {
        return authType;
    }

    public void setAuthType(AuthType authType) {
        this.authType = authType;
    }

    @Override
    public void performAuthentication() throws Exception{

        switch (authType) {
            case DB:
                AuthenticableDB.super.performAuthentication();
                break;
            case LDAP:
                AuthenticableLDAP.super.performAuthentication();
                break;

            default:
                throw new UserAuthException("unknown auth for user");
        }

    }
}
