package com.solvd.airport.service;

import com.solvd.airport.bin.Airport;
import com.solvd.airport.bin.Seat;

public interface SeatParserService {
    void marshall(Seat seat, String file);

    Airport unmarshall(String file);

}
