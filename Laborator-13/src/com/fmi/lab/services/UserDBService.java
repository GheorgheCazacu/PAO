package com.fmi.lab.services;

import com.fmi.lab.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDBService {


    private static final String SQL_FIND_ALL = "SELECT * FROM store.users";
    private static final String SQL_USER_INSERT = "INSERT INTO `store`.`users`\n" +
            "(`id`,\n" +
            "`username`,\n" +
            "`name`,\n" +
            "`date_of_birth`,\n" +
            "`cnp`)\n" +
            "VALUES\n" +
            "(?, ?, ?, ?, ? )";

    private static final String SQL_USER_UPDATE = "UPDATE `store`.`users`\n" +
            "SET\n" +
            "id = ?,\n" +
            "username = ?,\n" +
            "name = ?,\n" +
            "date_of_birth = ?,\n" +
            "cnp = ?\n" +
            "WHERE id = ?";

    private static UserDBService ourInstance = new UserDBService();

    public static UserDBService getInstance() {
        return ourInstance;
    }

    private UserDBService() {

    }

    /**
     * read of all users
     * @return
     */
    public List<User> findAll () {
        List<User> result = new ArrayList<>();
        ResultSet resultSet = DBService.getInstance().performQuery(SQL_FIND_ALL);
        try {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4) != null ?
                                new Date(resultSet.getDate(4).getYear(),
                                        resultSet.getDate(4).getMonth(),
                                        resultSet.getDate(4).getDate()) : null,
                        resultSet.getString(5));
                result.add(user);
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }

        return result;
    }

    /**
     * create a user
     * @param id
     * @param username
     * @param name
     * @param dateOfBirth
     * @param cnp
     * @return
     */
    public int create(long id, String username, String name, Date dateOfBirth, String cnp) {
        int result = 0;
        try {
            DBService.getInstance().performUpdate(SQL_USER_INSERT, id, username, name, dateOfBirth, cnp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * update a user
     * @param newId
     * @param username
     * @param name
     * @param dateOfBirth
     * @param cnp
     * @param currentId
     * @return
     */
    public int update(long newId, String username, String name, Date dateOfBirth, String cnp, long currentId) {
        int result = 0;
        try {
            DBService.getInstance().performUpdate(SQL_USER_UPDATE, newId, username, name, dateOfBirth, cnp, currentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
