package com.fmi.laborator.services;

import com.fmi.laborator.auth.Authenticable;

public class UserService {
    private static UserService ourInstance = new UserService();

    public static UserService getInstance() {
        return ourInstance;
    }

    private UserService() {
    }

    public boolean isAuth(Authenticable authenticable) {
        return authenticable.getHashPassword().equals("my token");
    }

}
