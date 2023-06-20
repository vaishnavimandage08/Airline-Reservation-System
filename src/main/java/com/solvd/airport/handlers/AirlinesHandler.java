package com.solvd.airport.handlers;

import com.solvd.airport.bin.Airlines;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class AirlinesHandler extends DefaultHandler {

    private static final String AIRLINE_ID = "airline_id";
    private static final String AIRLINE_NAME = "airline_name";
    private static final String AIRLINES = "airlines";

    private Airlines airline;
    private StringBuilder elementValue;

    public Airlines getResult() {
        return airline;
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
    public void startDocument() {
        airline = new Airlines();
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException, SAXException {
        super.startElement(uri, localName, qName, attributes);
        switch (qName) {
            case AIRLINE_ID:
            case AIRLINE_NAME:
                elementValue = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (airline != null) {
            switch (qName) {
                case AIRLINE_ID:
                    airline.setAirlineId(Integer.parseInt(elementValue.toString()));
                    break;
                case AIRLINE_NAME:
                    airline.setAirlineName(elementValue.toString());
                    break;
            }
        }
    }

}
