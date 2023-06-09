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
    @Override
    public Airplane get(int id)  {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Airplane airplane = null;
        try {
            connection = ConnectionPool.getConnection();
            String query = "SELECT * FROM Airplane WHERE Airplane_Id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int airplaneId = resultSet.getInt("Airplane_Id");
                String capacity = resultSet.getString("Capacity");

                airplane = new Airplane(airplaneId, capacity);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        finally {
            if (statement != null) {
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
        }
        return airplane;
    }

    @Override
    public int insert(Airplane airplane) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            connection = ConnectionPool.getConnection();
            String query = "INSERT INTO `airport`.`Airplane` (`AirplaneId`, `Capacity`) VALUES (?, ?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, airplane.getAirplaneId());
            statement.setString(2, airplane.getCapacity());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            if (statement != null) {
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
        }
        return result;
    }

    @Override
    public int update(Airplane airplane) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            connection = ConnectionPool.getConnection();
            String query = "INSERT INTO airplane(Airplane_Id, Capacity) VALUES (?, ?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, airplane.getAirplaneId());
            statement.setString(2, airplane.getCapacity());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
      }finally {
            if (statement != null) {
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
        }
        return result;
    }

    @Override
    public int delete(Airplane airplane) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            connection = ConnectionPool.getConnection();
            String query = "DELETE FROM airport WHERE AirplaneId = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, airplane.getAirplaneId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            if (statement != null) {
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
        }
        return result;
    }
}
