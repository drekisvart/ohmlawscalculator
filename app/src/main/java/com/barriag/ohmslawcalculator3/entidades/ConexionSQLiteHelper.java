package com.barriag.ohmslawcalculator3.entidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.barriag.ohmslawcalculator3.utlidades.Utilidades;


public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    public ConexionSQLiteHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_FORMULAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS formulas");
        onCreate(db);

    }

}
