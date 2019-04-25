package com.fmi.swing.example.services;


import com.fmi.swing.example.exceptions.UserBuildException;
import com.fmi.swing.example.exceptions.YearException;
import com.fmi.swing.example.models.User;

import java.text.ParseException;
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

        result = new User(RANDOM.nextInt(500_000), username, name, dateOfBirth, cnp);

        return result;
    }

    /**
     * build an user from a string with format
     * date format is a constant in <strong>User</strong> class
     * 22,username,first last,2000-03-22,1234567890123
     * @param line
     * @return
     */
    public User buildUserFromString(String line) throws UserBuildException {
        if (line == null) {
            throw new UserBuildException("input line parameter is null");
        }

        User user = null;
        String[] fields = line.split(",");

        if(fields.length != 5) {
            throw new UserBuildException("too many or too few fields are available on this line: " + line);
        }

        int id = 0;
        try {
            id = Integer.parseInt(fields[0].trim());
        } catch (NumberFormatException exc) {
            exc.printStackTrace();
        }

        String username = fields[1].trim();
        String name = fields[2].trim();
        Date dateOfBirth = null;
        try {
            dateOfBirth = User.SIMPLE_DATE_FORMAT.parse(fields[3].trim());
        } catch (ParseException exc) {
            exc.printStackTrace();
        }
        String cnp = fields[4].trim();

        user = new User(id, username, name, dateOfBirth, cnp);

        return user;
    }

}
