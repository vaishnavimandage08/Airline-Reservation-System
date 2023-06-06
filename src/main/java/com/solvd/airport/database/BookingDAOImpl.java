package com.solvd.airport.database;

import com.solvd.airport.DatabaseConnectionPool;
import com.solvd.airport.database.dao.BookingDao;
import com.solvd.airport.model.Airplane;
import com.solvd.airport.model.Airport;
import com.solvd.airport.model.Booking;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDAOImpl implements BookingDao {
    @Override
    public Booking get(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Booking booking = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        // Prepare the SQL statement
        String query = "SELECT * FROM Booking WHERE Booking_Id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        // Execute the query
        resultSet = statement.executeQuery();

        // Process the result set
        if (resultSet.next()) {
            // Retrieve the airport details from the result set
            int bookingId = resultSet.getInt("Booking_Id");
            int flightId = resultSet.getInt("Flight_ID");
            int passengerId = resultSet.getInt("Passanger_Id");
            String seatNumber = resultSet.getString("SeatNumber");
            int passengerDetailsId = resultSet.getInt("Passanger_Details_Id");

        }
        return booking;
    }

    @Override
    public int insert(Booking booking) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

// Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        String query = "INSERT INTO `airport`.`Booking` (`Booking_Id`, `Flight_Id`, `Passanger_Id`, `Seat_Number`, `Status`, `Passanger_Details_Passanger_Id`) VALUES (?, ?, ?, ?, ?, ?)";
        statement = connection.prepareStatement(query);
        statement.setInt(1, booking.getBookingId());
        statement.setInt(2, booking.getFlightId());
        statement.setInt(3, booking.getPassengerId());
        statement.setString(4, booking.getSeatNumber());
        statement.setString(5, booking.getStatus().name());
        statement.setInt(6, booking.getPassengerDetailsId());

        int result = statement.executeUpdate();
        return result;

    }

    @Override
    public int update(Booking booking) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

            // Obtain a connection from the connection pool
            connection = DatabaseConnectionPool.getConnection();

            String query = "UPDATE `airport`.`Booking` SET `Flight_Id` = ?, `Seat_Number` = ?, `Status` = ? WHERE `Booking_Id` = ? AND `Passanger_Details_Passanger_Id` = ?";
            statement = connection.prepareStatement(query);

            // Set the updated values
            statement.setInt(1, booking.getFlightId());
            statement.setString(2, booking.getSeatNumber());
            statement.setString(3, booking.getStatus().name());
            statement.setInt(4, booking.getBookingId());
            statement.setInt(5, booking.getPassengerDetailsId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected;

    }

    @Override
    public int delete(Booking booking) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // Obtain a connection from the connection pool
        connection = DatabaseConnectionPool.getConnection();
        String query = "DELETE from airport where Booking_Id =?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, booking.getBookingId());

        int result = statement.executeUpdate();
        return result;
    }
}
