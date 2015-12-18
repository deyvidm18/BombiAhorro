package dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import database.DatabaseHelper;

/**
 * Created by mac on 9/4/15.
 */
public class SuperDAO {

    protected SQLiteDatabase database;
    protected DatabaseHelper dbHelper;

    public SuperDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    protected void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    protected void close() {
        dbHelper.close();
    }
}
