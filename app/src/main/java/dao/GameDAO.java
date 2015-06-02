package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import database.DatabaseHelper;

public class GameDAO {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private String[] allColumns = {DatabaseHelper.KEY_SCORE};
    private String Orden = "10";


    public GameDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    private void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    private void close() {
        dbHelper.close();
    }

    public int[] mejores10() {
        int[] puntuaciones = new int[10];
        System.out.println("ENTROOOO");
        int auxtam = puntuaciones.length - 1;
        open();
        Cursor cursor = database.query(DatabaseHelper.TABLE_GAME, allColumns, null, null, null, null, "score DESC");
        Cursor cursor1 = database.rawQuery(" SELECT score FROM " + DatabaseHelper.TABLE_GAME, null);
        //Cursor cursor = database.query(DatabaseHelper.TABLE_GAME, allColumns, null, null, null, null, allColumns+" DESC", Orden);
        //Cursor cursor1 = database.rawQuery("SELECT "+allColumns+" FROM " + DatabaseHelper.TABLE_GAME +
//                " ORDER BY "+allColumns + " DESC"
//                , new String[] {});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            for (int i = 0; i <= auxtam; i++) {
                puntuaciones[i] = cursor.getInt(0);
                System.out.println("arreglo de mejores" + puntuaciones[i]);
                cursor.moveToNext();
            }
        }
        cursor.close();
        close();

        return puntuaciones;
    }

    public void Agregar(int puntuacion) {
        //Cursor cursor = database.query(DatabaseHelper.TABLE_GAME, allColumns, null, null, null, null, allColumns+" DESC");
        int[] aux_punt = new int[10];
        aux_punt = mejores10();
        open();
        int tamaÒo = aux_punt.length;
        System.out.println("el tamaÒo es de " + tamaÒo);
        for (int j = 0; j <= tamaÒo - 1; j++) {
            if (aux_punt[j] < puntuacion) {
                ContentValues dataToInsert = new ContentValues();
                dataToInsert.put("score", puntuacion);
                //dataToInsert.put(allColumns, puntuacion);
                database.update(DatabaseHelper.TABLE_GAME, dataToInsert, "score=" + aux_punt[tamaÒo - 1], null);

//				database.db
//				database.execSQL("UPDATE DatabaseHelper.TABLE_GAME SET nombre='usunuevo' WHERE codigo=6 ");
                j = tamaÒo;
                //aux_punt[tamaÒo-1] = puntuacion;
                //System.out.println("arreglo de puntuaiones agregadas"+aux_punt[j]);
                //Arrays.sort(aux_punt, Collections.reverseOrder());
            }
        }
        aux_punt = mejores10();
        close();
        for (int k = 0; k <= tamaÒo - 1; k++) {
            System.out.println("VALORES FINALES BD" + aux_punt[k]);
        }
    }


}
