package com.fmi.lab;

import com.fmi.lab.services.DBService;
import com.fmi.lab.services.UserDBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
//
//        int lastId = 0;
//
//        // perform a query examples
//        ResultSet resultSet = DBService.getInstance().performQuery("select * from users");
//        try {
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(2));
//                lastId = resultSet.getInt(1);
//            }
//        } catch (SQLException exc) {
//            exc.printStackTrace();
//        }
//
//        // perform an insert examples
//
//
//        String sqlUserInsert = "INSERT INTO `store`.`users`\n" +
//                "(`id`,\n" +
//                "`username`,\n" +
//                "`name`,\n" +
//                "`date_of_birth`,\n" +
//                "`cnp`)\n" +
//                "VALUES\n" +
//                "(?, ?, ?, ?, ? )";
//
//
//
//        try {
//            int i = DBService.getInstance().performUpdate(sqlUserInsert,
//                    lastId + 1,
//                    "auto-insert-name",
//                    "the second name",
//                    new Date(),
//                    "1234567890124");
//
//            System.out.println("affected rows = " + i);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        UserDBService.getInstance().findAll().forEach(System.out::println);

    }

}
