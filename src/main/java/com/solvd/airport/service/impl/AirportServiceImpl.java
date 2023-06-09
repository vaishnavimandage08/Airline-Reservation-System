package com.solvd.airport.service.impl;

import com.solvd.airport.bin.Airport;
import com.solvd.airport.dao.AirportDao;
import com.solvd.airport.dao.impl.AirportDAOImpl;
import com.solvd.airport.service.AirportService;

public class AirportServiceImpl implements AirportService {
    AirportDao airportDao = new AirportDAOImpl();
    @Override
    public void insertAirport(Airport airport) {
        if (airport != null) {
            airportDao.insert(airport);
        } else {
            throw new NullPointerException("Airport object is null. Cannot insert.");
        }
    }
    @Override
    public Airport getAirportById(int airportId) {
        if (airportId > 0) {
            return airportDao.get(airportId);
        } else {
            throw new IllegalArgumentException("Invalid airport ID. Cannot retrieve.");
        }
    }
}

