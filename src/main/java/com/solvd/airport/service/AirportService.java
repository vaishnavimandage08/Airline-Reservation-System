package com.solvd.airport.service;

import com.solvd.airport.bin.Airlines;
import com.solvd.airport.bin.Airport;

public interface AirportService {
    void insertAirport(Airport airport);

    Airport getAirportById(int airportId);

    void insertAirline(Airlines airline);

    void updateAirline(Airlines airline);
}
