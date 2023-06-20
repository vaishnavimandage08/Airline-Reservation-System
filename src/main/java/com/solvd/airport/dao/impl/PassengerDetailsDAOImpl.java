package com.solvd.airport.dao.impl;

import com.solvd.airport.bin.PassengerDetails;
import com.solvd.airport.util.ConnectionPool;
import com.solvd.airport.dao.PassengerDetailsDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PassengerDetailsDAOImpl implements PassengerDetailsDao {
    private static final Logger logger = LogManager.getLogger(PassengerDetailsDAOImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String UPDATE = "UPDATE PassengerDetails SET First_Name=?, Last_Name=?, Passport_Number=?, EmailAddress=?, Phone_Number=?, Age=?, Gender=? WHERE Passenger_Id=?";
    private static final String DELETE = "DELETE FROM PassengerDetails WHERE Passenger_Id=?";

    @Override
    public int update(PassengerDetails passengerDetails) {
        Connection connection = connectionPool.getConnection();
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, passengerDetails.getFirstName());
            preparedStatement.setString(2, passengerDetails.getLastName());
            preparedStatement.setString(3, passengerDetails.getPassportNumber());
            preparedStatement.setString(4, passengerDetails.getEmailAddress());
            preparedStatement.setString(5, passengerDetails.getPhoneNumber());
            preparedStatement.setInt(6, passengerDetails.getAge());
            preparedStatement.setString(7, passengerDetails.getGender());
            preparedStatement.setInt(8, passengerDetails.getPassengerId());

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public int delete(PassengerDetails passengerDetails) {
        Connection connection = connectionPool.getConnection();
        int result = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, passengerDetails.getPassengerId());

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public PassengerDetails get(int id)  {
        throw new UnsupportedOperationException("Method insert() is not implemented yet.");
    }

    @Override
    public int insert(PassengerDetails passengerdetails) {
        throw new UnsupportedOperationException("Method insert() is not implemented yet.");
    }
}
