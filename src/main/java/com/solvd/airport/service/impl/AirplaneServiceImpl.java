package com.solvd.airport.service.impl;
import com.solvd.airport.bin.Airplane;
import com.solvd.airport.dao.AirplaneDao;
import com.solvd.airport.dao.impl.AirplaneDAOImpl;
import com.solvd.airport.service.AirlineService;
import com.solvd.airport.service.AirplaneService;

public class AirplaneServiceImpl implements AirplaneService {

    AirplaneDao airplaneDao = new AirplaneDAOImpl();
    @Override
    public void updateAirplane(Airplane airplane) {
        airplaneDao.update(airplane);
    }
}

