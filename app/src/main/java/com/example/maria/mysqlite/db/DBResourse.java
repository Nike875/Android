package com.example.maria.mysqlite.db;

/**
 * Created by maria on 30/04/2017.
 */

public class DBResourse {
    static final String NAME_DB = "mydb.db";
    static final int VERSION_DB = 1;

    public class User {
        public static final String TABLE_NAME = "user";
        public static final String ID= "id";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String AGE = "age";
        public static final String NOTES = "notes";

        static final String CREATE_TABLE = " create table "+ TABLE_NAME
                + " ( "+ ID + " integer primary key autoincrement, "
                + FIRST_NAME + " text, " + LAST_NAME +" text, "
                + AGE + " integer, " + NOTES + " text);";
    }

}
