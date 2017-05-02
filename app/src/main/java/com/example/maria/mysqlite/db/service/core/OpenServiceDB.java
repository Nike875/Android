package com.example.maria.mysqlite.db.service.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.maria.mysqlite.db.DBHelper;

/**
 * Created by maria on 30/04/2017.
 */

public class OpenServiceDB  {
    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public boolean isOpenDB() {
        return dbHelper!=null && sqLiteDatabase !=null
                &&sqLiteDatabase.isOpen();
    }

    public SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    public void openDB(Context context){
        if(sqLiteDatabase == null && context!= null ){
            dbHelper = new DBHelper(context);
            try {
                sqLiteDatabase = dbHelper.getWritableDatabase();
            }catch(SQLiteException e){
                sqLiteDatabase = dbHelper.getReadableDatabase();
            }
        }

    }
    public void closeDB(){
        if (dbHelper!=null){
            dbHelper.close();
        }
    }

}
