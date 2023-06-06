package com.solvd.airport;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionPool {
    private static final String URL = "jdbc:mysql://localhost:3306/airport";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root123";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setDriverClassName(DRIVER_CLASS);

        // Set other connection pool properties
        dataSource.setMaxTotal(10); // Maximum number of connections
        dataSource.setInitialSize(5); // Initial number of connections
        // ... other configuration options
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public static DataSource getDataSource() {
        return dataSource;
    }
}
