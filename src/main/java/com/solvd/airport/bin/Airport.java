package com.solvd.airport.bin;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "airport")
@XmlAccessorType(XmlAccessType.FIELD)
public class Airport {
    @XmlElement
    private int airportId;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "country")
    private String country;
    @XmlElement(name = "city")
    private String city;

    public Airport() {

    }

    public Airport(int airportId, String name, String country, String city) {
        this.airportId = airportId;
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public int getAirportId() {
        return airportId;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport [Airport_Id=" + airportId + ", Name=" + name + ", Country=" + country + ", City=" + city + "]";
    }
}
