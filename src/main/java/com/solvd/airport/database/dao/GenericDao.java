package com.solvd.airport.database.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {

        T get(int id) throws SQLException;

        int insert(T t) throws SQLException;

        int update(T t) throws SQLException;

        int delete(T t) throws SQLException;
}
