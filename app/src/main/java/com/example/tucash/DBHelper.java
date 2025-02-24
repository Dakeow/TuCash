package com.example.tucash;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


// Se empieza la config de la base de datos
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tucash.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_APELLIDO = "apellido";
    public static final String COLUMN_CEDULA = "cedula";
    public static final String COLUMN_FECHA_NACIMIENTO = "fecha_nacimiento";
    public static final String COLUMN_CELULAR = "celular";
    public static final String COLUMN_CONTRASENA = "contrasena";

    private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_USERS + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NOMBRE + " TEXT, " +
            COLUMN_APELLIDO + " TEXT, " +
            COLUMN_CEDULA + " TEXT, " +
            COLUMN_FECHA_NACIMIENTO + " TEXT, " +
            COLUMN_CELULAR + " TEXT, " +
            COLUMN_CONTRASENA + " TEXT" +
            ");";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Por simplicidad, se elimina la tabla y se crea de nuevo en una actualización
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }
}
