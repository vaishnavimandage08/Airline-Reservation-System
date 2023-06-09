package com.solvd.airport.dao;

import java.sql.SQLException;

public interface IDao<T> {

        T get(int id) ;

        int insert(T t) ;

        int update(T t) ;

        int delete(T t);
}
