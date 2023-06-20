package com.solvd.airport.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.solvd.airport.bin.Booking;
import com.solvd.airport.bin.PassengerDetails;
import com.solvd.airport.bin.Payment;
import com.solvd.airport.bin.Tickets;
import com.solvd.airport.service.PaymentParserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class PaymentParserServiceImpl implements PaymentParserService {

    private final static Logger logger = LogManager.getLogger(PaymentParserServiceImpl.class);

    ObjectMapper objectMapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, true);



    @Override
    public void serialization(Payment payment, String file) {
        objectMapper.registerModule(new JavaTimeModule());
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File (file) ,payment);
        } catch (IOException e) {
            logger.error("IO Exception occurred while writing PassengerDetails to JSON file", e);
            throw new RuntimeException(e);
        }
    }
    @Override
    public void serialization(PassengerDetails passengerDetails, String file) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File (file) ,passengerDetails);
        } catch (IOException e) {
            logger.error("IO Exception occurred while writing PassengerDetails to JSON file", e);
            throw new RuntimeException(e);
        }
    }
    @Override
    public Booking deserializeBooking(String file) {

        Booking booking;
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        try {
            booking = objectMapper.readValue(new File(file), Booking.class);
        } catch (IOException e) {
            logger.error("File not found.");
            throw new RuntimeException(e);
        }
        return booking;
    }
    @Override
    public Tickets deserializeTickets(String file) {
        Tickets tickets;
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        try {
            tickets = objectMapper.readValue(new File (file), Tickets.class);
        } catch (IOException e) {
            logger.error("File not found.");
            throw new RuntimeException(e);
        }
        return tickets;
    }
}
