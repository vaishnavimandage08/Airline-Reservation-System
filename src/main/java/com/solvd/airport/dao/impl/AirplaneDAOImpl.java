package com.solvd.airport.dao.impl;

import com.solvd.airport.bin.Airplane;
import com.solvd.airport.util.ConnectionPool;
import com.solvd.airport.dao.AirplaneDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AirplaneDAOImpl implements AirplaneDao {
    private static final Logger logger = LogManager.getLogger(AirplaneDAOImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String INSERT = "INSERT INTO Airplane (Airplane_Id, Capacity) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE Airplane SET Capacity = ? WHERE Airplane_Id = ?";
    private static final String DELETE = "DELETE FROM Airplane WHERE Airplane_Id = ?";
    private static final String GET = "SELECT * FROM Airplane WHERE Airplane_Id = ?";

    @Override
    public Airplane get(int id) {
        Airplane airplane = null;
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(GET)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    int airplaneId = resultSet.getInt("Airplane_Id");
                    String capacity = resultSet.getString("Capacity");
                    airplane = new Airplane(airplaneId, capacity);
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return airplane;
    }

    @Override
    public int insert(Airplane airplane) {
        Connection connection = connectionPool.getConnection();
        int result = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setInt(1, airplane.getAirplaneId());
            preparedStatement.setString(2, airplane.getCapacity());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public int update(Airplane airplane) {
        Connection connection = connectionPool.getConnection();
        int result = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, airplane.getCapacity());
            preparedStatement.setInt(2, airplane.getAirplaneId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public int delete(Airplane airplane) {
        Connection connection = connectionPool.getConnection();
        int result = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, airplane.getAirplaneId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return result;
    }
}


