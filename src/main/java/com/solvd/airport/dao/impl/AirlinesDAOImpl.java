package com.solvd.airport.dao.impl;

import com.solvd.airport.bin.Airlines;
import com.solvd.airport.dao.AirlinesDao;
import com.solvd.airport.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AirlinesDAOImpl implements AirlinesDao {
    private static final Logger logger = LogManager.getLogger(AirlinesDAOImpl.class);

    @Override
    public Airlines get(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Airlines airlines = null;
        try {
            connection = ConnectionPool.getConnection();

            String query = "SELECT * FROM airlines WHERE Airline_Id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Retrieve the airline details from the result set
                int airlineId = resultSet.getInt("Airline_Id");
                String airlineName = resultSet.getString("Airline_Name");

                // Create an Airlines object
                airlines = new Airlines(airlineId, airlineName);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error("Failed to close result set: " + e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error("Failed to close statement: " + e.getMessage());
                }
            }
        }
        return airlines;
    }

    @Override
    public int insert(Airlines airlines) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            // Obtain a connection from the connection pool
            connection = ConnectionPool.getConnection();
            String query = "INSERT INTO airlines(Airline_Id, Airline_Name) VALUES (?, ?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, airlines.getAirlineId());
            statement.setString(2, airlines.getAirlineName());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error("Failed to close statement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Failed to close connection: " + e.getMessage());
                }
            }
        }
        return result;
    }

    @Override
    public int update(Airlines airlines) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            // Obtain a connection from the connection pool
            connection = ConnectionPool.getConnection();
            String query = "UPDATE airlines SET Airline_Name=? WHERE Airline_Id=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, airlines.getAirlineName());
            statement.setInt(2, airlines.getAirlineId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error("Failed to close statement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Failed to close connection: " + e.getMessage());
                }
            }
        }
        return result;
    }

    @Override
    public int delete(Airlines airlines) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            connection = ConnectionPool.getConnection();
            String query = "DELETE FROM airlines WHERE Airline_Id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, airlines.getAirlineId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error("Failed to close statement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Failed to close connection: " + e.getMessage());
                }
            }
        }
        return result;
    }
}
