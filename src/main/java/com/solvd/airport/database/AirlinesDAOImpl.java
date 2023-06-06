package com.solvd.airport.database;

import com.solvd.airport.model.Airlines;
import com.solvd.airport.database.dao.AirlinesDao;
import com.solvd.airport.DatabaseConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AirlinesDAOImpl implements AirlinesDao {
    @Override
    public Airlines get(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Airlines  airlines = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        // Prepare the SQL statement
        String query = "SELECT * FROM Airport WHERE Airline_Id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        // Execute the query
        resultSet = statement.executeQuery();

        // Process the result set
        if (resultSet.next()) {
            // Retrieve the airport details from the result set
            int airlineId = resultSet.getInt("Airline_Id");
            String airlineName = resultSet.getString("Airline_Name");

            // Create an Airport object
            airlines = new Airlines(airlineId, airlineName);
        }
        return airlines;
    }

    @Override
    public int insert(Airlines airlines) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        String query = "INSERT INTO airline(Airline_Id, Airline_Name(?,?)";
        statement = connection.prepareStatement(query);
        statement.setInt(1, airlines.getAirlineId());
        statement.setString(2, airlines.getAirlineName());

        int result = statement.executeUpdate();
        return result;
    }

    @Override
    public int update(Airlines airlines) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        String query = "UPDATE airline SET Airline_Name=? WHERE Airline_Id=?";
        statement = connection.prepareStatement(query);
        statement.setString(1, airlines.getAirlineName());
        statement.setInt(4, airlines.getAirlineId());

        int result = statement.executeUpdate();
        return result;
    }

    @Override
    public int delete(Airlines airlines) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        String query = "DELETE from airline where Airline_Id =?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, airlines.getAirlineId());

        int result = statement.executeUpdate();
        return result;
    }
}
