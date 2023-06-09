package com.solvd.airport.bin;

public class Airlines {

    private int airlineId;
    private String airlineName;

    public Airlines(int airlineId, String airlineName) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
}
