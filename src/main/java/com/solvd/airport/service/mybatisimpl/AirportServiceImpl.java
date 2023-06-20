package com.solvd.airport.service.mybatisimpl;

import com.solvd.airport.bin.Airport;
import com.solvd.airport.service.AirportService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AirportServiceImpl implements AirportService {
    private final static Logger logger = LogManager.getLogger(AirportServiceImpl.class);
    private static final String MYBATIS_CONFIG = "mybatis-config.xml";
    private final static String INSERT = "com.solvd.airport.db.mappers.AirportMapper.insertAirport";
    private final static String GET = "com.solvd.airport.db.mappers.AirportMapper.getAirportById";

    @Override
    public void insertAirport(Airport airport) {
        if (airport != null) {
            try (InputStream stream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
                SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
                try (SqlSession session = sessionFactory.openSession()) {
                    session.insert(INSERT, airport);
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
        if (airportId >= 1) {
            try (InputStream stream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
                SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
                try (SqlSession session = sessionFactory.openSession()) {
                    return session.selectOne(GET, airportId);
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
}
