package com.solvd.airport.service.impl;

import com.solvd.airport.bin.PassengerDetails;
import com.solvd.airport.dao.PassengerDetailsDao;
import com.solvd.airport.dao.impl.PassengerDetailsDAOImpl;
import com.solvd.airport.service.PassengerDetailsService;

public class PassengerDetailsServiceImpl implements PassengerDetailsService {

    PassengerDetailsDao passengerDao = new PassengerDetailsDAOImpl();

    @Override
    public void updatePassengerDetails(PassengerDetails details) {
        if (details != null) {
            passengerDao.update(details);
        } else {
            throw new IllegalArgumentException("Invalid passenger details. Cannot update.");
        }
    }
}