package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Names
    public static final String TABLE_CALCULATE = "calculate";
    public static final String TABLE_HISTORY = "history";
    public static final String TABLE_GAME = "game";
    // Common column names
    public static final String KEY_ID = "id";
    public static final String KEY_CREATED_AT = "created_at";
    // CALCULATE Table - column names
    public static final String KEY_NAME = "name";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_CONSUMPTION = "consumption";
    public static final String KEY_DRAWABLE = "drawable";
    // Table Create Statements
    // Calculate table create statement
    private static final String CREATE_TABLE_CALCULATE = "CREATE TABLE " + TABLE_CALCULATE + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT," + KEY_DESCRIPTION + " TEXT,"
            + KEY_CONSUMPTION + " REAL," + KEY_DRAWABLE + " TEXT," + KEY_CREATED_AT
            + " DATETIME DEFAULT CURRENT_TIMESTAMP" + ");";
    // Calculate table insert statement
    private static final String INSERT_TABLE_CALCULATE = "INSERT INTO " + TABLE_CALCULATE + " (" + KEY_NAME + ","
            + KEY_DESCRIPTION + "," + KEY_CONSUMPTION + "," + KEY_DRAWABLE
            + ") VALUES ('Calculadora', 'Calculadora de escritorio', '500','calculator'),"
            + "('Video Juego', 'Consola de video juego', '700','tv'),"
            + "('Computadora de escritorio', 'Computadora de escritorio', '1000','ventilador'),"
            + "('Impresora', 'Impresora', '100','printer'),"
            + "('Computadora Portatil', 'Computadora Portatil', '200','ventilador')";
    // HISTORY Table - column names
    public static final String KEY_RESULT_CONSUMPTION = "result_consumption";
    // History table create statement
    private static final String CREATE_TABLE_HISTORY = "CREATE TABLE " + TABLE_HISTORY + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_RESULT_CONSUMPTION + " REAL," + KEY_CREATED_AT
            + " DATETIME DEFAULT CURRENT_TIMESTAMP" + ")";
    // GAME Table - column names
    public static final String KEY_SCORE = "score";
    // Game table create statement
    private static final String CREATE_TABLE_GAME = "CREATE TABLE " + TABLE_GAME + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_SCORE + " REAL," + KEY_CREATED_AT
            + " DATETIME DEFAULT CURRENT_TIMESTAMP" + ")";
    // Database Version
    private static final int DATABASE_VERSION = 12;
    // Database Name
    private static final String DATABASE_NAME = "bombi_ahorro";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_CALCULATE);
        db.execSQL(INSERT_TABLE_CALCULATE);
        db.execSQL(CREATE_TABLE_HISTORY);
        db.execSQL(CREATE_TABLE_GAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALCULATE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GAME);
        // create new tables
        onCreate(db);
    }

}
