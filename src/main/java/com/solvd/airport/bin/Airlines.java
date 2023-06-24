package com.solvd.airport.bin;

import java.util.List;

public class Airlines {

    private int airlineId;
    private String airlineName;

    private List<Airlines> airlines;

    public Airlines(int airlineId, String airlineName) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.airlines = airlines;
    }

    public Airlines() {

    }

    public int getAirlineId() {
        return airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public List<Airlines> getAirlines() {
        return airlines;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public void setAirlines(List<Airlines> airlines) {
        this.airlines = airlines;
    }

    @Override
    public String toString() {
        return "Airlines{" + "airlineId=" + airlineId + ", airlineName='" + airlineName + '\'' + '}';
    }


}
