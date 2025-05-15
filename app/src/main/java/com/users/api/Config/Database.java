package com.users.api.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

    public static Connection connect() {
        Connection conn = null;

        Properties connectionProps = new Properties();
        connectionProps.setProperty("url", "jdbc:postgresql://usersApi-database:5432/usersApi");
        connectionProps.setProperty("user", "usersApi");
        connectionProps.setProperty("password", "usersApi");

        try {
            conn = DriverManager.getConnection(
                    connectionProps.getProperty("url"),
                    connectionProps.getProperty("user"),
                    connectionProps.getProperty("password"));

            System.out.println("Get connected successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
