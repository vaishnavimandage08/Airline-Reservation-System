package com.solvd.airport.dao.impl;

import com.solvd.airport.bin.Airlines;
import com.solvd.airport.dao.AirlinesDao;
import com.solvd.airport.handlers.AirlinesHandler;
import com.solvd.airport.handlers.FlightHandler;
import com.solvd.airport.util.ConnectionPool;
import org.apache.ibatis.javassist.compiler.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AirlinesDAOImpl implements AirlinesDao {
    private static final Logger logger = LogManager.getLogger(AirlinesDAOImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String INSERT ="INSERT INTO airlines(Airline_Id, Airline_Name) VALUES (?, ?)";
    private static final String UPDATE ="UPDATE airlines SET Airline_Name=? WHERE Airline_Id=?";
    private static final String DELETE ="DELETE FROM airlines WHERE Airline_Id = ?";
    private static final String Get ="SELECT * FROM airlines WHERE Airline_Id = ?";

    @Override
    public Airlines get(int id) {
        Airlines airlines = null;
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(Get)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    int airlineId = resultSet.getInt("Airline_Id");
                    String airlineName = resultSet.getString("Airline_Name");
                    airlines = new Airlines(airlineId, airlineName);
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return airlines;
    }
   @Override
    public int insert(Airlines airlines) {
       Connection connection = connectionPool.getConnection();
        int result = 0;
            try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT);){
                preparedStatement.setInt(1, airlines.getAirlineId());
                preparedStatement.setString(2, airlines.getAirlineName());
                result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
       return result;
   }

    @Override

    public int update(Airlines airlines) {
        Connection connection = connectionPool.getConnection();
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, airlines.getAirlineName());
            preparedStatement.setInt(2, airlines.getAirlineId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public int delete(Airlines airlines) {
        Connection connection = connectionPool.getConnection();
        int result = 0;

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, airlines.getAirlineId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return result;
    }

}
