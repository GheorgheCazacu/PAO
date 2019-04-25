package com.fmi.laborator.db;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store?serverTimezone=UTC",
                    "root", "samsung2018");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from users");

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {

                System.out.println("column name: " + resultSetMetaData.getColumnName(i)
                    + ", column type: " + resultSetMetaData.getColumnType(i));


            }


            while (resultSet.next()) {
                System.out.println("id=" + resultSet.getInt(1)
                        + ", username=" + resultSet.getString(2)
                        + ", date of birth=" + resultSet.getDate(4));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
