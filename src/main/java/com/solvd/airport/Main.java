package com.solvd.airport;

import com.solvd.airport.bin.*;
import com.solvd.airport.service.AirplaneService;
import com.solvd.airport.service.impl.AirlineServiceImpl;
import com.solvd.airport.service.mybatisimpl.AirplaneServiceImpl;
import com.solvd.airport.service.mybatisimpl.PassengerDetailsServiceImpl;
import com.solvd.airport.service.mybatisimpl.AirportServiceImpl;
import com.solvd.airport.service.impl.PaymentParserServiceImpl;
import com.solvd.airport.service.impl.SeatParserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        AirportServiceImpl airportServiceImpl = new AirportServiceImpl();
        // Create a new airport
        Airport airport = new Airport(11, "John Doe Airport", "USA", "New York");
        airportServiceImpl.insertAirport(airport);
        logger.info("Inserted airport: " + airport);

//        // Get an airport by its ID
        int airportId = 3;
        Airport retrievedAirport = airportServiceImpl.getAirportById(airportId);
        logger.info("Retrieved airport: " + retrievedAirport);

        // Creating new airlines
        airportServiceImpl.insertAirline(new Airlines(5, "ASA"));
        logger.info("New airline created.");

        // Updating airlines
        Airlines airline = new Airlines(1, "Delta");
        airportServiceImpl.updateAirline(airline);
        logger.info("Airline updated.");


        // Creating an instance of the service
        PassengerDetailsServiceImpl passengerDetailsServiceimpl = new PassengerDetailsServiceImpl();

        // Creating a passenger details object with parameters
        PassengerDetails details = new PassengerDetails(5, "Taylor", "doe", "AB123456", "taylor.doe@example.com", "1233567890", 25, "Male");

        // Updating passenger details
        passengerDetailsServiceimpl.updatePassengerDetails(details);
        logger.info("Passenger details updated.");

        // Create an instance of AirplaneService
        AirplaneService airplaneService = new AirplaneServiceImpl();

        Airplane airplane = new Airplane(3, "800");

        // Insert the airplane
        airplaneService.insertAirplane(airplane);
        logger.info("Airplane details inserted.");

        // Update the airplane
        airplane.setCapacity("Airbus A320");
        airplaneService.updateAirplane(airplane);
        logger.info("Airplane details updated.");

        AirlineServiceImpl airlineServiceImpl1 = new AirlineServiceImpl();
        logger.info(airlineServiceImpl1.getResult("src/main/resources/xml/airport.xml"));

        //JAXB marshalling
        SeatParserServiceImpl seatParserServiceImpl = new SeatParserServiceImpl();
        Seat seat = new Seat(123, "A1", Seat.ClassType.ECONOMY, "AVAILABLE", 456);
        String seatXmlFile = "src/main/resources/seat.xml";
        seatParserServiceImpl.marshall(seat, seatXmlFile);

        //JAXB unmarshalling
        String airportXmlFile = "src/main/resources/xml/input.xml";
        Airport airport1 = seatParserServiceImpl.unmarshall(airportXmlFile);
        logger.info("Airport details: " + airport1.getAirportId() + ", " + airport1.getName() + ", " +
                airport1.getCountry() + ", " + airport1.getCity());

        //JACKSON Serialize
        PaymentParserServiceImpl paymentParserServiceImpl = new PaymentParserServiceImpl();
        PassengerDetails passengerDetails = new PassengerDetails(8, "Tom", "Johnson", "HI789", "tom.johnson@example.com", "5555555555", 45, "Male");
        String file = "src/main/resources/json/payment.json";
        paymentParserServiceImpl.serialization(passengerDetails, file);
        Payment payment = new Payment(4, "Credit Card", LocalDateTime.parse("2023-06-13T14:30:00"), 100, 1, 1);
        String file1 = "src/main/resources/payment.json";
        paymentParserServiceImpl.serialization(payment, file1);
        logger.info("Serialization completed successfully.");

        //JACKSON Deserialize
        paymentParserServiceImpl = new PaymentParserServiceImpl();
        String JsonFile = "src/main/resources/json/booking.json";
        String JsonFile1 = "src/main/resources/json/tickets.json";
        Booking booking = paymentParserServiceImpl.deserializeBooking(JsonFile);
        Tickets tickets = paymentParserServiceImpl.deserializeTickets(JsonFile1);
        logger.info(booking);
        logger.info(tickets);
    }
}
