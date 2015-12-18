package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseHelper;
import model.HistoryModel;

public class HistoryDAO extends SuperDAO {

    private static final DateFormat myDateFormat = new SimpleDateFormat("MMM-yy");
    private static final DateFormat androidFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // Database fields
    private String[] allColumns = {DatabaseHelper.KEY_ID, DatabaseHelper.KEY_CREATED_AT, DatabaseHelper.KEY_RESULT_CONSUMPTION};

    public HistoryDAO(Context context) {
        super(context);
    }

    public void insertHistoryRecord(float consumption) {
        ContentValues values = new ContentValues();
        open();
        values.put(DatabaseHelper.KEY_RESULT_CONSUMPTION, consumption);
        verifyRecord();
        database.insert(DatabaseHelper.TABLE_HISTORY, null, values);
        close();
    }

    private void verifyRecord() {
        Cursor cursor = database.query(DatabaseHelper.TABLE_HISTORY, allColumns, null, null, null, null, DatabaseHelper.KEY_CREATED_AT + " " + DatabaseHelper.ORDER_ASC);
        if (cursor.getCount() > 6) {
            cursor.moveToFirst();
            database.delete(DatabaseHelper.TABLE_HISTORY, DatabaseHelper.KEY_ID + "=" + cursor.getInt(0), null);
        }
    }

    public List<HistoryModel> getAllHistoryModel() {
        List<HistoryModel> historyList = new ArrayList<HistoryModel>();
        open();
        Cursor cursor = database.query(DatabaseHelper.TABLE_HISTORY, allColumns, null, null, null, null, DatabaseHelper.KEY_CREATED_AT + " " + DatabaseHelper.ORDER_ASC);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            HistoryModel historyModel = cursorToHistoryModel(cursor);
            historyList.add(historyModel);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return historyList;
    }

    private HistoryModel cursorToHistoryModel(Cursor cursor) {
        HistoryModel historyModel = new HistoryModel();
        try {
            historyModel.setCreated(myDateFormat.format(androidFormat.parse(cursor.getString(1))));
        } catch (ParseException e) {
            //TODO Manejar excepcion
        }
        historyModel.setResultConsumption(cursor.getFloat(2));
        return historyModel;
    }

}
