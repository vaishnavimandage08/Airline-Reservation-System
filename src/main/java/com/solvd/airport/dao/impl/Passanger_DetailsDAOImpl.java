package com.solvd.airport.dao.impl;

import com.solvd.airport.bin.Passanger_Details;
import com.solvd.airport.util.ConnectionPool;
import com.solvd.airport.dao.Passanger_DetailsDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Passanger_DetailsDAOImpl implements Passanger_DetailsDao {
    private static final Logger logger = LogManager.getLogger(Passanger_DetailsDAOImpl.class);


    @Override
    public int update(Passanger_Details passanger_details) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            connection = ConnectionPool.getConnection();
            String query = "UPDATE `airport`.`Passanger_Details` SET `First_Name` = ?, `Last_Name` = ?, `Passport_Number` = ?, `EmailAddress` = ?, `Phone_Number` = ?, `Age` = ?, `Gender` = ? WHERE `Passanger_Id` = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, passanger_details.getFirstName());
            statement.setString(2, passanger_details.getLastName());
            statement.setString(3, passanger_details.getPassportNumber());
            statement.setString(4, passanger_details.getEmailAddress());
            statement.setString(5, passanger_details.getPhoneNumber());
            statement.setInt(6, passanger_details.getAge());
            statement.setString(7, passanger_details.getGender());
            statement.setInt(8, passanger_details.getPassengerId());

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
    public int delete(Passanger_Details passanger_details) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            connection = ConnectionPool.getConnection();
            String query = "DELETE FROM airport WHERE Passenger_Id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, passanger_details.getPassengerId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }    if (statement != null) {
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
    public Passanger_Details get(int id)  {
        throw new UnsupportedOperationException("Method insert() is not implemented yet.");
    }

    @Override
    public int insert(Passanger_Details passanger_details) {
        throw new UnsupportedOperationException("Method insert() is not implemented yet.");
    }
}
