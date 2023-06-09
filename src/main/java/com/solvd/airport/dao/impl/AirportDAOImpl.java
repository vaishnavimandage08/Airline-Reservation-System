package com.solvd.airport.dao.impl;

import com.solvd.airport.bin.Airport;
import com.solvd.airport.dao.AirportDao;
import com.solvd.airport.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AirportDAOImpl implements AirportDao {
    private static final Logger logger = LogManager.getLogger(AirplaneDAOImpl.class);

    @Override
    public Airport get(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Airport airport = null;
        try {
            connection = ConnectionPool.getConnection();

            String query = "SELECT * FROM airport WHERE Airport_Id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int airportId = resultSet.getInt("Airport_Id");
                String name = resultSet.getString("Name");
                String country = resultSet.getString("Country");
                String city = resultSet.getString("City");

                airport = new Airport(airportId, name, country, city);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
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
        return airport;
    }

    @Override
    public int insert(Airport airport)  {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = ConnectionPool.getConnection();
            String query = "INSERT INTO airport(Airport_Id, Name, Country, City) VALUES (?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, airport.getAirportId());
            statement.setString(2, airport.getName());
            statement.setString(3, airport.getCountry());
            statement.setString(4, airport.getCity());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
       }
        finally {
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
    public int update(Airport airport)  {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = ConnectionPool.getConnection();
            String query = "UPDATE airport SET Name=?, Country=?, City=? WHERE Airport_Id=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, airport.getName());
            statement.setString(2, airport.getCountry());
            statement.setString(3, airport.getCity());
            statement.setInt(4, airport.getAirportId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
     }
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
        return result;
    }


    @Override
    public int delete(Airport airport)
    {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = ConnectionPool.getConnection();
            String query = "DELETE FROM airport WHERE Airport_Id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, airport.getAirportId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
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
        return result;
    }
}
