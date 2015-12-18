package dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import database.DatabaseHelper;
import model.CalculateModel;

public class CalculateDAO extends SuperDAO {

    // Database fields
    private String[] allColumns = {DatabaseHelper.KEY_ID, DatabaseHelper.KEY_CREATED_AT, DatabaseHelper.KEY_NAME,
            DatabaseHelper.KEY_DESCRIPTION, DatabaseHelper.KEY_CONSUMPTION, DatabaseHelper.KEY_DRAWABLE};

    public CalculateDAO(Context context) {
        super(context);
    }

    public List<CalculateModel> getAllCalculateModel() {
        List<CalculateModel> calculateList = new ArrayList<CalculateModel>();
        open();
        Cursor cursor = database.query(DatabaseHelper.TABLE_CALCULATE, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CalculateModel calculateModel = cursorToCalculateModel(cursor);
            calculateList.add(calculateModel);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return calculateList;
    }

    private CalculateModel cursorToCalculateModel(Cursor cursor) {
        CalculateModel calculateModel = new CalculateModel();
        calculateModel.setName(cursor.getString(2));
        calculateModel.setDescription(cursor.getString(3));
        calculateModel.setConsumption(cursor.getFloat(4));
        calculateModel.setDrawable(cursor.getString(5));
        return calculateModel;
    }
}
