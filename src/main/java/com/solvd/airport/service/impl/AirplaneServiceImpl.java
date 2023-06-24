package com.solvd.airport.service.impl;
import com.solvd.airport.bin.Airlines;
import com.solvd.airport.bin.Airplane;
import com.solvd.airport.bin.Airport;
import com.solvd.airport.dao.AirplaneDao;
import com.solvd.airport.dao.impl.AirplaneDAOImpl;
import com.solvd.airport.service.AirlineService;
import com.solvd.airport.service.AirplaneService;

public class AirplaneServiceImpl implements AirplaneService {

    AirplaneDao airplaneDao = new AirplaneDAOImpl();
    @Override
    public void updateAirplane(Airplane airplane) {
        if (airplane != null) {
            airplaneDao.update(airplane);
        } else {
            throw new NullPointerException("airplane object is null. Cannot update.");
        }
    }

    @Override
    public void insertAirplane(Airplane airplane) {
        if (airplane != null) {
            airplaneDao.insert(airplane);
        } else {
            throw new NullPointerException("airplane object is null. Cannot insert.");
        }
    }


}

