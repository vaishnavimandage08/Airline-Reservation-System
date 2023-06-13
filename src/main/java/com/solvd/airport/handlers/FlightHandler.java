package com.solvd.airport.handlers;

import com.solvd.airport.bin.Flight;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class FlightHandler extends DefaultHandler {
    private static final String ARRIVAL = "arrival";
    private static final String FROM_AIRPORT_ID = "fromAirportId";
    private static final String TO_AIRPORT_ID = "toAirportId";
    private static final String DEPARTURE = "departure";
    private static final String DURATION = "duration";

    private static final String FLIGHT = "flight";

    private List<Flight> flights;
    private Flight flight;
    private StringBuilder elementValue;

    public List<Flight> getResult() {
        return flights;
    }

    @Override
    public void startDocument() {
        flights = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName) {
            case ARRIVAL:
            case FROM_AIRPORT_ID:
            case TO_AIRPORT_ID:
            case DEPARTURE:
            case DURATION:
                elementValue = new StringBuilder();
                break;
            case FLIGHT:
                flight = new Flight();
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (elementValue != null) {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (flight != null) {
            switch (qName) {
                case ARRIVAL:
                    flight.setArrival(LocalDateTime.parse(elementValue.toString()));
                    break;
                case FROM_AIRPORT_ID:
                    flight.setFromAirportId(Integer.parseInt(elementValue.toString()));
                    break;
                case TO_AIRPORT_ID:
                    flight.setToAirportId(Integer.parseInt(elementValue.toString()));
                    break;
                case DEPARTURE:
                    flight.setDeparture(LocalDateTime.parse(elementValue.toString()));
                    break;
                case DURATION:
                    flight.setDuration(elementValue.toString());
                    break;
                case FLIGHT:
                    flights.add(flight);
            }
        }
        elementValue = null;
    }
}