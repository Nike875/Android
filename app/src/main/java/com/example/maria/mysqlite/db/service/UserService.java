package com.example.maria.mysqlite.db.service;

import android.content.Context;

import com.example.maria.mysqlite.db.dao.UserDao;
import com.example.maria.mysqlite.db.service.core.OpenServiceDB;
import com.example.maria.mysqlite.db.service.core.Service;
import com.example.maria.mysqlite.domain.User;

import java.util.List;

/**
 * Created by maria on 30/04/2017.
 */

public class UserService extends OpenServiceDB implements Service<User> {
    private Context context;

    public UserService(Context context) {
        this.context = context;
    }

    @Override
    public long save(User user) {
        try {

            if (!isOpenDB()) {
                openDB(context);
            }
            return new UserDao(getSqLiteDatabase()).save(user);
        } finally {
            if (isOpenDB())
                closeDB();
        }
    }

    @Override
    public List<User> getAll() {
       try{
           if (!isOpenDB()) {
            openDB(context);}
        return new UserDao(getSqLiteDatabase()).getAll();
    }finally{
        if (isOpenDB())
            closeDB();
    }
}

    @Override
    public User getById(long id) {
        try{
            if (!isOpenDB()) {
            openDB(context);
        }
        return new UserDao(getSqLiteDatabase()).getById(id);
    }finally {
        if (isOpenDB())
        closeDB();
        }
    }

    @Override
    public long update(User user) {
       try{
           if (!isOpenDB()) {
        openDB(context);
        }
        return new UserDao(getSqLiteDatabase()).update(user);
        }finally {
        if (isOpenDB())
        closeDB();
        }
    }

    @Override
    public long delete(long id) {
        try{
            if (!isOpenDB()) {
        openDB(context);
        }
        return new UserDao(getSqLiteDatabase()).delete(id);
        }finally {
        if (isOpenDB())
        closeDB();
        }
    }
}
