package com.solvd.airport.service.impl;

import com.solvd.airport.bin.Passanger_Details;
import com.solvd.airport.dao.Passanger_DetailsDao;
import com.solvd.airport.dao.impl.Passanger_DetailsDAOImpl;
import com.solvd.airport.service.PassangerDetailsService;

public class PassangerDetailsServiceImpl implements PassangerDetailsService {

    Passanger_DetailsDao passangerDao = new Passanger_DetailsDAOImpl();

    @Override
    public void updatePassengerDetails(Passanger_Details details) {
        if (details != null) {
            passangerDao.update(details);
        } else {
            throw new IllegalArgumentException("Invalid passenger details. Cannot update.");
        }
    }
}