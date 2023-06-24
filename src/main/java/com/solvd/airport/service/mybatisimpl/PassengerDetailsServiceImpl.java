package com.solvd.airport.service.mybatisimpl;

import com.solvd.airport.bin.PassengerDetails;
import com.solvd.airport.service.PassengerDetailsService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class PassengerDetailsServiceImpl implements PassengerDetailsService {
    private final static Logger logger = LogManager.getLogger(PassengerDetailsService.class);
    private static final String MYBATIS_CONFIG = "mybatis-config.xml";
    @Override
    public void updatePassengerDetails(PassengerDetails details) {

            if (details != null) {
                try (InputStream stream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
                    try (SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
                        session.update("com.solvd.airport.dao.PassengerDetailsDao.updatePassengerDetails", details);
                        session.commit();
                    }
                } catch (IOException e) {
                    logger.error("File Not Found", e);
                    throw new RuntimeException(e);
                }
            } else {
                logger.error("PassengerDetails object is null.");
                throw new NullPointerException();
            }
        }
}
