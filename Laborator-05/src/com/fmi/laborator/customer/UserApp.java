package com.fmi.laborator.customer;

import com.fmi.laborator.auth.Authenticable;
import com.fmi.laborator.model.User;

public final class UserApp extends User implements Authenticable {

    private String userName;
    private String hashPassword;

    public UserApp(String userName, String hashPassword) {
        this.userName = userName;
        this.hashPassword = hashPassword;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getHashPassword() {
        return hashPassword;
    }
}
