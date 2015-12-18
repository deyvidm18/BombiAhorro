package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import database.DatabaseHelper;

public class GameDAO extends SuperDAO {

    private String[] allColumns = {DatabaseHelper.KEY_SCORE};
    private String Orden = "10";

    public GameDAO(Context context) {
        super(context);
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
        int size = aux_punt.length;
        System.out.println("el tamaño es de " + size);
        for (int j = 0; j <= size - 1; j++) {
            if (aux_punt[j] < puntuacion) {
                ContentValues dataToInsert = new ContentValues();
                dataToInsert.put("score", puntuacion);
                //dataToInsert.put(allColumns, puntuacion);
                database.update(DatabaseHelper.TABLE_GAME, dataToInsert, "score=" + aux_punt[size - 1], null);

//				database.db
//				database.execSQL("UPDATE DatabaseHelper.TABLE_GAME SET nombre='usunuevo' WHERE codigo=6 ");
                j = size;
                //aux_punt[tamaÒo-1] = puntuacion;
                //System.out.println("arreglo de puntuaiones agregadas"+aux_punt[j]);
                //Arrays.sort(aux_punt, Collections.reverseOrder());
            }
        }
        aux_punt = mejores10();
        close();
        for (int k = 0; k <= size - 1; k++) {
            System.out.println("VALORES FINALES BD" + aux_punt[k]);
        }
    }


}
