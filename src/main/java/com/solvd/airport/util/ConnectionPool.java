package com.solvd.airport.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {

    private final static Logger logger = LogManager.getLogger(ConnectionPool.class);

    private static final int MAX_POOL_SIZE = 5;

    public static ConnectionPool connectionPool;

    private List<Connection> connections;
    private Properties properties;

    public ConnectionPool() {
        connections = new ArrayList<>();
        properties = loadProperties();
        initializePool();
    }

    public static synchronized ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file.", e);
        }
        return properties;
    }

    private void initializePool() {
        String dbUrl = properties.getProperty("db.url");
        String dbUser = properties.getProperty("db.username");
        String dbPassword = properties.getProperty("db.password");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < MAX_POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                connections.add(connection);
            }
            logger.debug("Connection pool initialized with " + connections.size() + " connections.");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Failed to initialize connection pool.", e);
        }
    }

    public synchronized Connection getConnection() {
        while (connections.isEmpty()) {
            try {
                logger.debug("No available connections in the pool. Waiting for a connection...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection connection = connections.remove(connections.size() - 1);
        logger.debug("Acquired connection from the pool. Current pool size: " + connections.size());
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        connections.add(connection);
        logger.debug("Released connection to the pool. Current pool size: {}", connections.size());
        notify();
    }
}