package com.fmi.laborator6;

import com.fmi.laborator6.exceptions.UserAuthException;
import com.fmi.laborator6.model.User;

public class Laborator06Main {


    public static void main(String[] args) {


        User userDB = new User("user name DB", "hash password", User.AuthType.DB);
        User userLDAP = new User("user name LDAP", "hash password", User.AuthType.LDAP);

        try {
            userDB.performAuthentication();
        } catch (Exception exc) {
            exc.printStackTrace();
        }


    }

}
