package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String ORDER_ASC = "ASC";
    public static final String ORDER_DESC = "DESC";
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
    // GAME Table - column names
    public static final String KEY_SCORE = "score";
    // HISTORY Table - column names
    public static final String KEY_RESULT_CONSUMPTION = "result_consumption";
    private static final String CONST_INSERT_CALCULATE = ") VALUES ('Bombillo Ahorrador', 'Bombillo Ahorrador', '500','calculate_ahorrador'),"
            + "('Aire Acondicionador', 'Aire Acondicionador', '700','calculate_aire'),"
            + "('Bombillo', 'Bombillo', '1000','calculate_bombillo'),"
            + "('Cafetera', 'Cafetera', '100','calculate_cafetera'),"
            + "('Cocina', 'Cocina', '200','calculate_cocina'),"
            + "('Computadora', 'Computadora', '200','calculate_compu'),"
            + "('DVD', 'DVD', '200','calculate_dvd'),"
            + "('Lavadora', 'Lavadora', '200','calculate_lavadora'),"
            + "('Licuadora', 'Licuadora', '200','calculate_licuadora'),"
            + "('Microondas', 'Microondas', '200','calculate_micro'),"
            + "('Nevera', 'Nevera', '200','calculate_nevera'),"
            + "('Consola de Juegos', 'Consola de Juegos', '200','calculate_nintendo'),"
            + "('Plancha', 'Plancha', '200','calculate_plancha'),"
            + "('Secador', 'Secador', '200','calculate_secador'),"
            + "('Secadora', 'Secadora', '200','calculate_secadora'),"
            + "('Equipo de Sonido', 'Equipo de Sonido', '200','calculate_sonido'),"
            + "('Televisor', 'Televisor', '200','calculate_tele')";
    // Table Create Statements
    // CalculateFragment table create statement
    private static final String CREATE_TABLE_CALCULATE = "CREATE TABLE " + TABLE_CALCULATE + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT," + KEY_DESCRIPTION + " TEXT,"
            + KEY_CONSUMPTION + " REAL," + KEY_DRAWABLE + " TEXT," + KEY_CREATED_AT
            + " DATETIME DEFAULT CURRENT_TIMESTAMP" + ");";
    // GAME INSERT
    // CalculateFragment table insert statement
    private static final String INSERT_TABLE_GAME = "INSERT INTO " + TABLE_GAME + " (" + KEY_SCORE + ") VALUES ('10');";
    private static final String INSERT_TABLE_GAME1 = "INSERT INTO " + TABLE_GAME + " (" + KEY_SCORE + ") VALUES ('9'); ";
    private static final String INSERT_TABLE_GAME2 = "INSERT INTO " + TABLE_GAME + " (" + KEY_SCORE + ") VALUES ('3'); ";
    private static final String INSERT_TABLE_GAME3 = "INSERT INTO " + TABLE_GAME + " (" + KEY_SCORE + ") VALUES ('3'); ";
    private static final String INSERT_TABLE_GAME4 = "INSERT INTO " + TABLE_GAME + " (" + KEY_SCORE + ") VALUES ('4'); ";
    private static final String INSERT_TABLE_GAME5 = "INSERT INTO " + TABLE_GAME + " (" + KEY_SCORE + ") VALUES ('5'); ";
    private static final String INSERT_TABLE_GAME6 = "INSERT INTO " + TABLE_GAME + " (" + KEY_SCORE + ") VALUES ('8'); ";
    private static final String INSERT_TABLE_GAME7 = "INSERT INTO " + TABLE_GAME + " (" + KEY_SCORE + ") VALUES ('7'); ";
    private static final String INSERT_TABLE_GAME8 = "INSERT INTO " + TABLE_GAME + " (" + KEY_SCORE + ") VALUES ('7'); ";
    private static final String INSERT_TABLE_GAME9 = "INSERT INTO " + TABLE_GAME + " (" + KEY_SCORE + ") VALUES ('6'); ";
    private static final String INSERT_TABLE_GAME10 = "INSERT INTO " + TABLE_GAME + " (" + KEY_SCORE + ") VALUES ('0'); ";
    private static final String INSERT_TABLE_GAME11 = "INSERT INTO " + TABLE_GAME + " (" + KEY_SCORE + ") VALUES ('0'); ";
    // CalculateFragment table insert statement
    private static final String INSERT_TABLE_CALCULATE = "INSERT INTO " + TABLE_CALCULATE + " (" + KEY_NAME + ","
            + KEY_DESCRIPTION + "," + KEY_CONSUMPTION + "," + KEY_DRAWABLE
            + CONST_INSERT_CALCULATE;
    // HistoryFragment table create statement
    private static final String CREATE_TABLE_HISTORY = "CREATE TABLE " + TABLE_HISTORY + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_RESULT_CONSUMPTION + " REAL," + KEY_CREATED_AT
            + " DATETIME DEFAULT CURRENT_TIMESTAMP" + ")";
    // GameFragment table create statement
    private static final String CREATE_TABLE_GAME = "CREATE TABLE " + TABLE_GAME + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_SCORE + " REAL," + KEY_CREATED_AT
            + " STRING" + ")";
    // Database Version
    private static final int DATABASE_VERSION = 20;
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
       /* db.execSQL(INSERT_TABLE_GAME1);
        db.execSQL(INSERT_TABLE_GAME2);
        db.execSQL(INSERT_TABLE_GAME3);
        db.execSQL(INSERT_TABLE_GAME4);
        db.execSQL(INSERT_TABLE_GAME5);
        db.execSQL(INSERT_TABLE_GAME6);
        db.execSQL(INSERT_TABLE_GAME7);
        db.execSQL(INSERT_TABLE_GAME8);
        db.execSQL(INSERT_TABLE_GAME9);
        db.execSQL(INSERT_TABLE_GAME);*/
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
