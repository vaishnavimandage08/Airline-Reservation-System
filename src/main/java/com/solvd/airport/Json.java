package com.solvd.airport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.solvd.airport.bin.Booking;
import com.solvd.airport.bin.PassengerDetails;
import com.solvd.airport.bin.Payment;
import com.solvd.airport.bin.Tickets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class Json {
    private static final Logger logger = LogManager.getLogger(Json.class);

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        // Serialization (Java object to JSON)
        try {
            PassengerDetails passengerDetails = new PassengerDetails(8, "Tom", "Johnson", "HI789", "tom.johnson@example.com", "5555555555", 45, "Male");
            Payment payment = new Payment(4, "Credit Card", LocalDateTime.parse("2023-06-13T14:30:00"), 100, 1, 1);

            objectMapper.writeValue(new File("src/main/resources/details.json"), passengerDetails);
            objectMapper.writeValue(new File("src/main/resources/payment.json"), payment);
        } catch (JsonProcessingException e) {
            logger.error("Error occurred while writing PassengerDetails to JSON file", e);
        } catch (IOException e) {
            logger.error("IO Exception occurred while writing PassengerDetails to JSON file", e);
        }

        // Deserialization (JSON to Java object)
        try {
            String jsonBooking = "{\"bookingId\": 1, \"flightId\": 123, \"seatNumber\": \"A1\", \"status\": \"BOOKED\", \"passengerDetailsId\": 789}";
            Booking booking = objectMapper.readValue(jsonBooking, Booking.class);
            String jsonTickets = "{\"ticketId\": 1, \"seatNumber\": \"A1\", \"price\": 100, \"purchaseDate\": \"2023-06-13T14:30:00\", \"seatId\": 123, \"passengerDetailsId\": 456}";
            Tickets tickets = objectMapper.readValue(jsonTickets, Tickets.class);
            logger.info(booking);
            logger.info(tickets);
        } catch (JsonMappingException e) {
            logger.error("Error occurred while mapping JSON to Booking object", e);
        } catch (JsonProcessingException e) {
            logger.error("JsonProcessingException occurred while mapping JSON to Booking object", e);
        }
    }
}
