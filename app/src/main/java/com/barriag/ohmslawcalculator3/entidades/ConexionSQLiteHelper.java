package com.barriag.ohmslawcalculator3.entidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class ConexionSQLiteHelper extends SQLiteOpenHelper {

 final String CREAR_FORMULAS = "CREATE TABLE formulas (id String, voltaje INTEGER, resistencia INTEGER, corriente INTEGER, potencia INTEGER, resultado INTEGER)";
    public ConexionSQLiteHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_FORMULAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS formulas");
        onCreate(db);

    }
}
