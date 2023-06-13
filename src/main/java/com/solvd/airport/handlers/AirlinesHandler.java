package com.solvd.airport.handlers;

import com.solvd.airport.bin.Airlines;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class AirlinesHandler extends DefaultHandler {

    private static final String AIRLINE_ID = "airline_id";
    private static final String AIRLINE_NAME = "airline_name";
    private static final String AIRLINE = "airline";

    private Airlines airline;
    private StringBuilder elementValue;
    private List<Airlines> airlines;

    public List<Airlines> getAirlines() {
        return airlines;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void startDocument(){
        airlines = new ArrayList<>();
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName) {
            case AIRLINE_ID:
            case AIRLINE_NAME:
                elementValue = new StringBuilder();
                break;
            case AIRLINE:
                airline = new Airlines();
                break;
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName){
        if (airline != null) {
            switch (qName) {
                case AIRLINE_ID:
                    airline.setAirlineId(Integer.parseInt(elementValue.toString()));
                    break;
                case AIRLINE_NAME:
                    airline.setAirlineName(elementValue.toString());
                    break;
                case AIRLINE:
                    airlines.add(airline);
            }
        }
        elementValue = null;
    }
}


