package com.solvd.airport.service;

import com.solvd.airport.bin.Booking;
import com.solvd.airport.bin.PassengerDetails;
import com.solvd.airport.bin.Payment;
import com.solvd.airport.bin.Tickets;

public interface PaymentParserService {
    void serialization(Payment payment, String file);

    void serialization(PassengerDetails passengerDetails, String file);

    Booking deserializeBooking(String file);

    Tickets deserializeTickets(String file);
}
