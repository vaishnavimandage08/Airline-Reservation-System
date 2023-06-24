package com.solvd.airport.service.mybatisimpl;

import com.solvd.airport.bin.Airlines;
import com.solvd.airport.bin.Airport;
import com.solvd.airport.service.AirportService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;


public class AirportServiceImpl implements AirportService {
    private final static Logger logger = LogManager.getLogger(AirportServiceImpl.class);
    private static final String MYBATIS_CONFIG = "mybatis-config.xml";


    @Override
    public void insertAirport(Airport airport) {
        if (airport != null) {
            try (InputStream stream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
                try(SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()){
                    session.insert("com.solvd.airport.dao.AirportDao.insertAirport", airport);
                    session.commit();
                }
            } catch (IOException e) {
                logger.error("File Not Found");
                throw new RuntimeException(e);
            }
        } else {
            logger.error("Airport object is null.");
            throw new NullPointerException();
        }
    }

    @Override
    public Airport getAirportById(int airportId) {
        if (airportId > 0) {
            try (InputStream stream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
                try(SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()){
                    return session.selectOne("com.solvd.airport.dao.AirportDao.getAirportById", airportId);
                }
            } catch (IOException e) {
                logger.error("File Not Found");
                throw new RuntimeException(e);
            }
        } else {
            logger.error("Invalid airport ID was entered.");
            throw new IllegalArgumentException("Airport ID must be greater than or equal to 1");
        }
    }
    @Override
    public void insertAirline(Airlines airline) {
        if (airline != null) {
            try (InputStream stream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    session.insert("com.solvd.airport.dao.AirlinesDao.insertAirline", airline);
                    session.commit();
                }
            } catch (IOException e) {
                logger.error("File Not Found", e);

                throw new RuntimeException(e);
            }
        } else {
            logger.error("Airline object is null.");
            throw new NullPointerException();
        }
    }

    @Override
    public void updateAirline(Airlines airline) {
        if (airline != null) {
            try (InputStream stream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    session.update("com.solvd.airport.dao.AirlinesDao.getAirlineById", airline);
                    session.commit();
                }
            } catch (IOException e) {
                logger.error("File Not Found", e);
                throw new RuntimeException(e);
            }
        } else {
            logger.error("Airline object is null.");
            throw new NullPointerException();
        }
    }

}
