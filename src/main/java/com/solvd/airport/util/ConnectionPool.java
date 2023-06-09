package com.solvd.airport.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    private static final String PROPERTIES_FILE = "properties";

    public static Connection getConnection() {

         Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream("src/main/resources/properties")) {
            properties.load(input);
        }catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.username"), properties.getProperty("db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}