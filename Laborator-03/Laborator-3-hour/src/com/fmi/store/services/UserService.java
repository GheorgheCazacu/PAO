package com.fmi.store.services;

import com.fmi.store.models.User;

public class UserService {


    private static final User listOfUsers[] = new User[4];

    private static final UserService instance = new UserService();

    private UserService() {
        listOfUsers[0] = new User(1, "Ioana", "password");
        listOfUsers[1] = new User(2, "Adelin", "password");
        listOfUsers[2] = new User(3, "Marcu", "password");
        listOfUsers[3] = new User(4, "Doru", "password");
    }

    public static UserService getInstance() {
        return instance;
    }

    public static User getOne(String username) {

        for(User user : listOfUsers) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static User getOne(Integer userId) {

        for(User user : listOfUsers) {
            if(user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }



}
