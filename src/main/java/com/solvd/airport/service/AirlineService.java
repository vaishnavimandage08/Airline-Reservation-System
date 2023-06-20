package com.solvd.airport.service;
import com.solvd.airport.bin.Airlines;

import java.util.List;

public interface AirlineService {

    void insertAirline(Airlines airline);
    void updateAirline(Airlines airline);
    void deleteAirline(Airlines airline);
    Airlines getResult(String uri);

}
