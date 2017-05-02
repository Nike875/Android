package com.example.maria.mysqlite.db.service.core;

import java.util.List;

/**
 * Created by maria on 30/04/2017.
 */

public interface Service<T> {
   long save(T t);
   List<T> getAll();
   T getById(long id);
    long update(T t);
    long delete(long id);

}
