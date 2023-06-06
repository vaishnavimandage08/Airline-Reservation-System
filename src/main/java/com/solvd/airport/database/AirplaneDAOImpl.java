package com.solvd.airport.database;

import com.solvd.airport.DatabaseConnectionPool;
import com.solvd.airport.database.dao.AirplaneDao;
import com.solvd.airport.model.Airplane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AirplaneDAOImpl implements AirplaneDao {
    @Override
    public Airplane get(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Airplane airplane = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        // Prepare the SQL statement
        String query = "SELECT * FROM Airplane WHERE Airplane_Id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        // Execute the query
        resultSet = statement.executeQuery();

        // Process the result set
        if (resultSet.next()) {
            // Retrieve the airport details from the result set
            int airplaneId = resultSet.getInt("Airplane_Id");
            String capacity = resultSet.getString("Capacity");


            airplane = new Airplane(airplaneId, capacity);
        }
        return airplane;
    }

    @Override
    public int insert(Airplane airplane) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        String query = "INSERT INTO `airport`.`Airplane` (`AirplaneId`, `Capacity`) VALUES (?, ?)";
        statement = connection.prepareStatement(query);
        statement.setInt(1, airplane.getAirplaneId());
        statement.setString(2, airplane.getCapacity());


        int result = statement.executeUpdate();
        return result;
    }

    @Override
    public int update(Airplane airplane) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        String query = "INSERT INTO airplane(Airplane_Id, Capacity)VALUES(?,?)";
        statement = connection.prepareStatement(query);
        statement.setInt(1, airplane.getAirplaneId());
        statement.setString(2, airplane.getCapacity());


        int result = statement.executeUpdate();
        return result;
    }

    @Override
    public int delete(Airplane airplane) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        String query = "DELETE from airport where AirplaneId =?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, airplane.getAirplaneId());

        int result = statement.executeUpdate();
        return result;
    }
}
