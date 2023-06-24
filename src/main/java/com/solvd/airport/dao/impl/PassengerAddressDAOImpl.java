package com.solvd.airport.dao.impl;

import com.solvd.airport.bin.PassengerAddress;
import com.solvd.airport.dao.PassengerAddressDao;
import com.solvd.airport.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PassengerAddressDAOImpl implements PassengerAddressDao {
    private static final Logger logger = LogManager.getLogger(PassengerAddressDAOImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String DELETE = "DELETE FROM PassengerAddress WHERE Id = ?";

    @Override
    public int delete(int id) {
        Connection connection = connectionPool.getConnection();
        int result = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public PassengerAddress get(int id) {

        throw new UnsupportedOperationException("Method get() is not implemented yet.");
    }

    @Override
    public int insert(PassengerAddress passengerAddress) {
        throw new UnsupportedOperationException("Method insert() is not implemented yet.");
    }

    @Override
    public int update(PassengerAddress passengerAddress) {
        throw new UnsupportedOperationException("Method update() is not implemented yet.");
    }
}
