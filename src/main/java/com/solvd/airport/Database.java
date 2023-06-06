package com.solvd.airport;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Database {
    private static Connection connection = null;

    private static String url = "jdbc:mariadb://localhost:3306/airport";
    private static String user = "root";
    private static String password = "root123";

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

}
