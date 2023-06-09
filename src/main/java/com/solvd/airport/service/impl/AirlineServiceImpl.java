package com.solvd.airport.service.impl;

import com.solvd.airport.bin.Airlines;
import com.solvd.airport.dao.AirlinesDao;
import com.solvd.airport.dao.impl.AirlinesDAOImpl;
import com.solvd.airport.service.AirlineService;

public class AirlineServiceImpl implements AirlineService {
    AirlinesDao airlinesDao = new AirlinesDAOImpl();


    @Override
    public void insertAirline(Airlines airline) {
        if (airline != null) {
            airlinesDao.insert(airline);
        } else {
            throw new NullPointerException("airline object is null. Cannot insert.");
        }
    }

    @Override
    public void updateAirline(Airlines airline) {
        airlinesDao.update(airline);
    }

    @Override
    public void deleteAirline(Airlines airline) {
        airlinesDao.delete(airline);
    }
}