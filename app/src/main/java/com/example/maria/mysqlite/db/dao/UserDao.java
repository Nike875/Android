package com.example.maria.mysqlite.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.maria.mysqlite.db.DBResourse;
import com.example.maria.mysqlite.db.dao.cor.Dao;
import com.example.maria.mysqlite.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maria on 30/04/2017.
 */

public class UserDao implements Dao<User> {
    private SQLiteDatabase sqLiteDatabase;

    public UserDao(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }
    private ContentValues fullUserContentValue(User user){
        ContentValues values = new ContentValues();
        values.put(DBResourse.User.FIRST_NAME, user.getFirstName());
        values.put(DBResourse.User.LAST_NAME, user.getLastName());
        values.put(DBResourse.User.AGE, user.getAge());
        values.put(DBResourse.User.NOTES,user.getNotes() );
    return values;
    }

    @Override
    public long save(User user) {
        return sqLiteDatabase.insert(DBResourse.User.TABLE_NAME,null,
                fullUserContentValue(user));
    }

    @Override
    public List<User> getAll() {
        return parseCursor(sqLiteDatabase.rawQuery("Select *from user", null));
    }

    @Override
    public User getById(long id) {
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from user where id = ?",
                new String[]{String.valueOf(id)});
        if (cursor!=null && cursor.moveToFirst())
          return parseCursor(cursor).get(0);
        return null;
    }

    @Override
    public long update(User user) {
        return sqLiteDatabase.update(DBResourse.User.TABLE_NAME,
                fullUserContentValue(user), DBResourse.User.ID + " = ?",
                new String[]{String.valueOf(user.getId())});
    }

    @Override
    public long delete(long id) {
        return sqLiteDatabase.delete(DBResourse.User.TABLE_NAME,
                DBResourse.User.ID + " = ? ", new String[]{String.valueOf(id)});
    }

    @Override
    public List<User> parseCursor(Cursor cursor) {
       List <User> user = new ArrayList<>() ;
        if(cursor!= null && cursor.moveToFirst())
            do {
                long id = cursor.getLong(cursor.getColumnIndex(DBResourse.User.ID));
                String firstName = cursor.getString(cursor.getColumnIndex(DBResourse.User.FIRST_NAME));
                String lastName = cursor.getString(cursor.getColumnIndex(DBResourse.User.LAST_NAME));
                int age = cursor.getInt(cursor.getColumnIndex(DBResourse.User.AGE));
                String notes = cursor.getString(cursor.getColumnIndex(DBResourse.User.NOTES));

                user.add(new User(id, firstName, lastName, age, notes));
            } while (cursor.moveToNext());

    if(cursor!=null)
        cursor.close();
        return user;
}

}
