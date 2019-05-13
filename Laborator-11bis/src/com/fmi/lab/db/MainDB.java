package com.fmi.lab.db;

import java.sql.*;

public class MainDB {

    public static void main(String[] args) {

        // DriverManager

        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:h2:~/test",
                            "sa", "");

            Statement statement = connection.createStatement();

//            statement.executeUpdate("CREATE TABLE " +
//                    "product(id int auto_increment PRIMARY KEY, " +
//                    "name varchar(128), " +
//                    "category varchar(128))");

//            for(int i = 2; i < 11; i++) {
//                statement.executeUpdate("INSERT INTO product" +
//                        "(name, category)" +
//                        "VALUES ('product-" + i + "', 'category of product')");
//
//            }

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from product where name like ?");

            preparedStatement.setString(1, "product-%");


            ResultSet resultSet = preparedStatement.executeQuery(); // statement.executeQuery("select * from product");

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            for(int i = 1; i < resultSetMetaData.getColumnCount() + 1; i++) {
                System.out.println("column name: " + resultSetMetaData.getColumnName(i)
                        + ", column type: " + resultSetMetaData.getColumnTypeName(i));

            }



            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt(1)
                    + ", name: " + resultSet.getString(2)
                    + ", category: " + resultSet.getString(3));
            }


            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }


}
