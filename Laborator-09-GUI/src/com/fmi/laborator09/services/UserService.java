package com.fmi.laborator09.services;

import com.fmi.laborator09.exceptions.YearException;
import com.fmi.laborator09.models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class UserService {
    private static final List<User> USER_LIST = new ArrayList<>();
    private static final Random RANDOM = new Random(44);

    private static UserService ourInstance = new UserService();

    public static UserService getInstance() {
        return ourInstance;
    }


    private UserService() {
        USER_LIST.addAll(buildListOfUsers(50));
    }

    /**
     *
     * @return
     */
    public List<User> findAll() {
        //TODO clone also the users
        List<User> result = new ArrayList<>();
        result.addAll(USER_LIST);
        return result;
    }



    /**
     *
     * @param howMany
     * @return
     */
    private List<User> buildListOfUsers(int howMany) {
        List<User> users = new ArrayList<>();
        for(int i = 0; i < howMany; i++) {
            users.add(buildRandomUser());
        }
        return users;
    }

    /**
     * generate a random user using RandomGeneratorService
     * @return
     */
    private User buildRandomUser() {
        User result = null;
        String name = RandomGeneratorService.getInstance().getRandomName();
        String[] names = name.split(" ");
        String username = names[0].toLowerCase() + names[1].toLowerCase();
        Date dateOfBirth = new Date();
        //TODO find something better
        String cnp = "01234567890123";
        try {
            dateOfBirth = RandomGeneratorService.getInstance().getRandomDateBetween(1980, 2000);
        } catch (YearException exc) {
            exc.printStackTrace();
            // if something is going wrong we have a default value above
        }

        result = new User(RANDOM.nextInt(50_000_000), username, name, dateOfBirth, cnp);

        return result;
    }

}
