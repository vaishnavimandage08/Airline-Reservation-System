package com.solvd.airport.database;

import com.solvd.airport.DatabaseConnectionPool;
import com.solvd.airport.database.dao.Passanger_DetailsDao;
import com.solvd.airport.model.Passanger_Details;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Passanger_DetailsDAOImpl implements Passanger_DetailsDao {

    @Override
    public Passanger_Details get(int id) throws SQLException {
        return null;
    }

    @Override
    public int insert(Passanger_Details passanger_details) throws SQLException {
        return 0;
    }

    @Override
    public int update(Passanger_Details passanger_details) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        String query = "INSERT INTO `airport`.`Passanger_Details` (`Passanger_Id`, `First_Name`, `Last_Name`, `Passport_Number`, `EmailAddress`, `Phone_Number`, `Age`, `Gender`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        statement = connection.prepareStatement(query);
        statement.setInt(1, passanger_details.getPassengerId());
        statement.setString(2, passanger_details.getFirstName());
        statement.setString(3,passanger_details.getLastName());
        statement.setString(4,passanger_details.getPassportNumber());
        statement.setString(4,passanger_details.getEmailAddress());
        statement.setString(4,passanger_details.getPhoneNumber());
        statement.setInt(4,passanger_details.getAge());
        statement.setString(4,passanger_details.getGender());

        int result = statement.executeUpdate();
        return result;
    }

    @Override
    public int delete(Passanger_Details passanger_details) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        String query = "DELETE from airport where Passenger_Id =?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, passanger_details.getPassengerId());

        int result = statement.executeUpdate();
        return result;
    }
}
