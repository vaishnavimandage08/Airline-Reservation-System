package com.solvd.airport.service.impl;

import com.solvd.airport.bin.Airport;
import com.solvd.airport.bin.Seat;
import com.solvd.airport.service.SeatParserService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class SeatParserServiceImpl implements SeatParserService {
    private final static Logger logger = LogManager.getLogger(SeatParserService.class);

    @Override
    public void marshall(Seat seat, String file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Seat.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(seat, new File(file));
            logger.info("XML file generated successfully.");
        } catch (JAXBException e) {
            throw new RuntimeException("Error marshalling Seat", e);
        }
    }

    @Override
    public Airport unmarshall(String file) {
        Airport airport1;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Airport.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
             airport1 = (Airport) unmarshaller.unmarshal(new File (file));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return airport1;
    }
}
