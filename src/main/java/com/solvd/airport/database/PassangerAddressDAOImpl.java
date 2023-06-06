package com.solvd.airport.database;

import com.solvd.airport.DatabaseConnectionPool;
import com.solvd.airport.database.dao.PassangerAddressDao;
import com.solvd.airport.model.PassangerAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassangerAddressDAOImpl implements PassangerAddressDao {

    @Override
    public PassangerAddress get(int id) throws SQLException {
        return null;
    }

    @Override
    public int insert(PassangerAddress passangerAddress) throws SQLException {
        return 0;
    }

    @Override
    public int update(PassangerAddress passangerAddress) throws SQLException {
        return 0;
    }

    @Override
    public int delete(PassangerAddress passangerAddress) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        String query = "DELETE from airport where Id =?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, passangerAddress.getPassengerDetailsId());

        int result = statement.executeUpdate();
        return result;
    }
}
