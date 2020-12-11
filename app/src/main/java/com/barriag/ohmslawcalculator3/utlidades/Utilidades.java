package com.barriag.ohmslawcalculator3.utlidades;

public class Utilidades {

    //campos tabla formulas
    public static final String TABLA_FORMULAS = "formulas";
    public static final String CAMPO_ID  = "id";
    public static final String CAMPO_VOLTAJE = "voltaje";
    public static final String CAMPO_RESISTENCIA  = "resistencia";
    public static final String CAMPO_CORRIENTE  = "corriente";
    public static final String CAMPO_POTENCIA = "potencia";
    public static final String CAMPO_RESULTADO = "resultado";


    public static final String CREAR_FORMULAS = "CREATE TABLE "+TABLA_FORMULAS+" ("+CAMPO_ID+" TEXT, "+CAMPO_VOLTAJE+" INTEGER," +
             " "+CAMPO_RESISTENCIA+" INTEGER, "+CAMPO_CORRIENTE+" INTEGER, "+CAMPO_POTENCIA+" INTEGER, "+CAMPO_RESULTADO+" INTEGER)";

}
