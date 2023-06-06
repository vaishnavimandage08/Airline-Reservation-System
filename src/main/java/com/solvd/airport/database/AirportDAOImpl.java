package com.solvd.airport.database;

import com.solvd.airport.model.Airport;
import com.solvd.airport.database.dao.AirportDao;
import com.solvd.airport.DatabaseConnectionPool;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AirportDAOImpl implements AirportDao {

    @Override
    public Airport get(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Airport airport = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        // Prepare the SQL statement
        String query = "SELECT * FROM Airport WHERE Airport_Id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        // Execute the query
        resultSet = statement.executeQuery();

        // Process the result set
        if (resultSet.next()) {
            // Retrieve the airport details from the result set
            int airportId = resultSet.getInt("Airport_Id");
            String name = resultSet.getString("Name");
            String country = resultSet.getString("Country");
            String city = resultSet.getString("City");

            // Create an Airport object
            airport = new Airport(airportId, name, country, city);
        }
        return airport;
    }

    @Override
    public int insert(Airport airport) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        String query = "INSERT INTO airport(Airport_Id, Name, Country, City)VALUES(?,?,?,?)";
        statement = connection.prepareStatement(query);
        statement.setInt(1, airport.getAirportId());
        statement.setString(2, airport.getName());
        statement.setString(3,airport.getCountry());
        statement.setString(4,airport.getCity());

        int result = statement.executeUpdate();
        return result;

    }

    @Override
    public int update(Airport airport) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        String query = "UPDATE airport SET Name=?, Country=?, City=? WHERE Airport_Id=?";
        statement = connection.prepareStatement(query);
        statement.setString(1, airport.getName());
        statement.setString(2, airport.getCountry());
        statement.setString(3, airport.getCity());
        statement.setInt(4, airport.getAirportId());

        int result = statement.executeUpdate();
        return result;
    }


    @Override
    public int delete(Airport airport) throws SQLException {

            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            // Obtain a connection from the connection pool
            connection = DatabaseConnectionPool.getConnection();
            String query = "DELETE from airport where Airport_Id =?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, airport.getAirportId());

            int result = statement.executeUpdate();
            return result;
    }
}
