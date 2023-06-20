package com.solvd.airport.dao.impl;

import com.solvd.airport.bin.Airport;
import com.solvd.airport.dao.AirportDao;
import com.solvd.airport.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AirportDAOImpl implements AirportDao {
    private static final Logger logger = LogManager.getLogger(AirportDAOImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String GET = "SELECT * FROM airport WHERE Airport_Id = ?";
    private static final String INSERT = "INSERT INTO airport (Airport_Id, Name, Country, City) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE airport SET Name = ?, Country = ?, City = ? WHERE Airport_Id = ?";
    private static final String DELETE = "DELETE FROM airport WHERE Airport_Id = ?";

    @Override
    public Airport get(int id) {
        Airport airport = null;
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(GET)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    int airportId = resultSet.getInt("Airport_Id");
                    String name = resultSet.getString("Name");
                    String country = resultSet.getString("Country");
                    String city = resultSet.getString("City");
                    airport = new Airport(airportId, name, country, city);
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return airport;
    }

    @Override
    public int insert(Airport airport) {
        Connection connection = connectionPool.getConnection();
        int result = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setInt(1, airport.getAirportId());
            preparedStatement.setString(2, airport.getName());
            preparedStatement.setString(3, airport.getCountry());
            preparedStatement.setString(4, airport.getCity());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public int update(Airport airport) {
        Connection connection = connectionPool.getConnection();
        int result = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, airport.getName());
            preparedStatement.setString(2, airport.getCountry());
            preparedStatement.setString(3, airport.getCity());
            preparedStatement.setInt(4, airport.getAirportId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public int delete(Airport airport) {
        Connection connection = connectionPool.getConnection();
        int result = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, airport.getAirportId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return result;
    }
}

