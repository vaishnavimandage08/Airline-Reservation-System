package com.solvd.airport.database;

import com.solvd.airport.database.dao.FlightDao;
import com.solvd.airport.model.Flight;

import java.sql.SQLException;

public class FlightDAOImpl implements FlightDao {
    @Override
    public Flight get(int id) throws SQLException {
        return null;
    }

    @Override
    public int insert(Flight flight) throws SQLException {
        return 0;
    }

    @Override
    public int update(Flight flight) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Flight flight) throws SQLException {
        return 0;
    }
}
