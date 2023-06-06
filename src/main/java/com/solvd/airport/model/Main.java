package com.solvd.airport.model;
import com.solvd.airport.database.AirportDAOImpl;
import com.solvd.airport.database.dao.AirportDao;
import com.solvd.airport.model.Airport;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Airport airport = new Airport(1, "Airport 1", "Country 1", "City 1");
          AirportDao airportDao = new AirportDAOImpl();
        // Get the airport by ID
        Airport retrievedAirport = airportDao.get(1);
        System.out.println("Retrieved airport: " + retrievedAirport);
//
//        new Airport(6, "SeaTac", "United States","Tacoma" );
//        int result = airportDao.insert(airport);
//        new Airport(4, "SFO", "United States","Texas" );
//        airportDao.update(airport);
//        System.out.println(airport);
//
//          airportDao.get(6);
//          System.out.println(airport);
//           result = airportDao.delete(airport);
//          System.out.println(result);

    }
}
