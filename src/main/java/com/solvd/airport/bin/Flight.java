package com.solvd.airport.bin;

import java.time.LocalDateTime;

public class Flight {
    private int flightId;
    private LocalDateTime arrival;
    private int fromAirportId;
    private int toAirportId;
    private LocalDateTime departure;
    private String duration;
    private int airportId;
    private int airplaneId;

    public int getFlightId() {
        return flightId;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public int getFromAirportId() {
        return fromAirportId;
    }

    public int getToAirportId() {
        return toAirportId;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public String getDuration() {
        return duration;
    }

    public int getAirportId() {
        return airportId;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public void setFromAirportId(int fromAirportId) {
        this.fromAirportId = fromAirportId;
    }

    public void setToAirportId(int toAirportId) {
        this.toAirportId = toAirportId;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }
    @Override
    public String toString() {
        return "Flight{" +
                "arrival=" + arrival +
                ", fromAirportId=" + fromAirportId +
                ", toAirportId=" + toAirportId +
                ", departure=" + departure +
                ", duration='" + duration + '\'' +
                '}';
    }
}
