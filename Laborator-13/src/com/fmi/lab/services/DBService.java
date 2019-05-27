package com.fmi.lab.services;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.Date;

public class DBService {

    private static final MysqlDataSource dataSource = new MysqlDataSource();
    private static Connection connection;

    private static final String DB_NAME = "store";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "fmi2019";
    private static final String SERVER_NAME = "localhost";

    private static final DBService ourInstance = new DBService();

    public static DBService getInstance() {
        return ourInstance;
    }

    private DBService() {
        initDataSource();

    }

    /**
     * initialize the db using parameters from statics
     */
    public void initDataSource() {

        try {
            dataSource.setDatabaseName(DB_NAME);
            dataSource.setUser(USERNAME);
            dataSource.setPassword(PASSWORD);
            dataSource.setServerName(SERVER_NAME);
            dataSource.setServerTimezone("UTC");

            DBService.connection = dataSource.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                closeConnection();
            }
        });

    }

    /**
     * perform a query using given sql
     * @param sql
     * @return
     */
    public ResultSet performQuery(String sql) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = DBService.connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    /**
     * perform an update (e.g. insert, update) query using given sql
     * @param sql
     * @return
     */
    public int  performUpdate(String sql) {
        int resultSet = 0;
        try {
            PreparedStatement preparedStatement = DBService.connection.prepareStatement(sql);

            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * perform an update (e.g. insert, update) query using given sql
     * @param sql
     * @return
     */
    public int  performUpdate(String sql, Object ... objs) throws Exception {
        int resultSet = 0;
        try {
            PreparedStatement preparedStatement = DBService.connection.prepareStatement(sql);

            for(int i = 0; i < objs.length; i++) {
                switch (objs[i].getClass().getSimpleName()) {
                    case "String":
                        preparedStatement.setString(i + 1, (String) objs[i]);
                        break;
                    case "Date":
                        java.sql.Date date = new java.sql.Date(((Date) objs[i]).getTime());
                        preparedStatement.setDate(i + 1, date);
                        break;
                    case "Integer":
                        preparedStatement.setInt(i + 1, (Integer) objs[i]);
                        break;
                    case "Double":
                        preparedStatement.setDouble(i + 1, (Double) objs[i]);
                        break;
                    default:
                        throw new Exception("unknown data type");
                }

            }

            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    /**
     * close connection at exit, see the hook in constructor
     */
    public void closeConnection() {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
