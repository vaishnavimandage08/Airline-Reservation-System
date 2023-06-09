package com.solvd.airport;
import com.solvd.airport.bin.Airlines;
import com.solvd.airport.bin.Airport;
import com.solvd.airport.bin.Passanger_Details;
import com.solvd.airport.service.AirlineService;
import com.solvd.airport.service.AirportService;
import com.solvd.airport.service.PassangerDetailsService;
import com.solvd.airport.service.impl.AirlineServiceImpl;
import com.solvd.airport.service.impl.AirportServiceImpl;
import com.solvd.airport.service.impl.PassangerDetailsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        AirportService airportService = new AirportServiceImpl();
        // Create a new airport
        Airport airport = new Airport(7, "Setac", "United States", "Tacoma");
        airportService.insertAirport(airport);
        logger.info("Inserted airport: " + airport);


        // Get an airport by its ID
        int airportId = 3;
        Airport retrievedAirport = airportService.getAirportById(airportId);
        logger.info("Retrieved airport: " + retrievedAirport);

        // Creating new airlines
        AirlineService airlineService = new AirlineServiceImpl();
        airlineService.insertAirline(new Airlines(1, "Delta"));
        logger.info("New airline created.");

        // Updating airlines
        Airlines airline = new Airlines(1, "Delta");
        airline.setAirlineName("Updated Airline 1");
        airlineService.updateAirline(airline);
        logger.info("Airline updated.");

        // Deleting airlines
        airlineService.deleteAirline(airline);
        logger.info("Airline deleted.");

        // Creating an instance of the service
        PassangerDetailsService passangerDetailsService = new PassangerDetailsServiceImpl();

        // Creating a passenger details object with parameters
        Passanger_Details details = new Passanger_Details(5, "Taylor", "doe", "AB123456", "taylor.doe@example.com", "1233567890", 25, "Male");

        // Updating passenger details
        passangerDetailsService.updatePassengerDetails(details);
        logger.info("Passenger details updated.");
    }
}
