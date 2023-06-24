package com.solvd.airport.service;

import com.solvd.airport.bin.Airlines;

public interface AirlineService {

    void insertAirline(Airlines airline);

    void updateAirline(Airlines airline);

    void deleteAirline(int airlineId);

    Airlines getResult(String uri);

}
