package com.solvd.airport.service.mybatisimpl;

import com.solvd.airport.bin.Airplane;
import com.solvd.airport.service.AirplaneService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class AirplaneServiceImpl implements AirplaneService {
    private final static Logger logger = LogManager.getLogger(AirportServiceImpl.class);
    private static final String MYBATIS_CONFIG = "mybatis-config.xml";

    @Override
    public void insertAirplane(Airplane airplane) {
        if (airplane != null) {
            try (InputStream stream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    session.insert("com.solvd.airport.dao.AirplaneDao.insertAirplane", airplane);
                    session.commit();
                }
            } catch (IOException e) {
                logger.error("File Not Found", e);
                throw new RuntimeException(e);
            }
        } else {
            logger.error("Airplane object is null.");
            throw new NullPointerException();
        }
    }

    @Override
    public void updateAirplane(Airplane airplane) {
        if (airplane != null) {
            try (InputStream stream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
                try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                    session.update("com.solvd.airport.dao.AirplaneDao.updateAirplane", airplane);
                    session.commit();
                }
            } catch (IOException e) {
                logger.error("File Not Found", e);
                throw new RuntimeException(e);
            }
        } else {
            logger.error("Airplane object is null.");
            throw new NullPointerException();
        }
    }

}
