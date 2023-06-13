package com.solvd.airport;

import com.solvd.airport.bin.Airlines;
import com.solvd.airport.bin.Flight;
import com.solvd.airport.handlers.AirlinesHandler;
import com.solvd.airport.handlers.FlightHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaxParser {
    private static final Logger logger = LogManager.getLogger(SaxParser.class);

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();

            FlightHandler flightHandler = new FlightHandler();
            saxParser.parse(new File("src/main/resources/airport.xml"), flightHandler);
            List<Flight> flights = flightHandler.getResult();


            for (Flight flight : flights) {
                logger.info(flight);
            }

            // Parse airlines
            AirlinesHandler airlinesHandler = new AirlinesHandler();
            saxParser.parse(new File("src/main/resources/airport.xml"), airlinesHandler);
            List<Airlines> airlines = airlinesHandler.getAirlines();
            for (Airlines airline : airlines) {
                logger.info(airline);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
