package com.solvd.airport.dao.impl;

import com.solvd.airport.bin.PassangerAddress;
import com.solvd.airport.util.ConnectionPool;
import com.solvd.airport.dao.PassangerAddressDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PassangerAddressDAOImpl implements PassangerAddressDao {
    private static final Logger logger = LogManager.getLogger(PassangerAddressDAOImpl.class);

    @Override
    public int delete(PassangerAddress passangerAddress)  {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            connection = ConnectionPool.getConnection();
            String query = "DELETE FROM PassangerAddress WHERE Id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, passangerAddress.getPassengerDetailsId());

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
    public PassangerAddress get(int id)  {

        throw new UnsupportedOperationException("Method insert() is not implemented yet.");
    }

    @Override
    public int insert(PassangerAddress passangerAddress) {
        throw new UnsupportedOperationException("Method insert() is not implemented yet.");
    }
    @Override
    public int update(PassangerAddress passangerAddress) {
        throw new UnsupportedOperationException("Method insert() is not implemented yet.");
    }
}
