package com.barriag.ohmslawcalculator3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.barriag.ohmslawcalculator3.entidades.ConexionSQLiteHelper;
import com.barriag.ohmslawcalculator3.utlidades.Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText et_voltaje;
    EditText et_corriente;
    EditText et_resistencia;
    EditText et_potencia;
    TextView tv_resultado;
    EditText et_nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        et_voltaje = findViewById(R.id.et_voltaje);
        et_corriente = findViewById(R.id.et_corriente);
        et_resistencia = findViewById(R.id.et_resistencia);
        et_potencia = findViewById(R.id.et_potencia);
        tv_resultado = findViewById(R.id.tv_resultado);
        et_nombre = findViewById(R.id.et_nombre);

    }
    //VOLTAJE
    @SuppressLint("SetTextI18n")
    public void voltaje (View view) {

        Integer curr = Integer.parseInt(et_corriente.getText().toString());
        Integer amps = Integer.parseInt(et_resistencia.getText().toString());

        int volt = curr * amps;
        String resultv = String.valueOf(volt);

        tv_resultado.setText(String.format("%s%s", resultv, String.format(" V")));




    }
    //CORRIENTE
    public void corriente (View view) {

        Integer vol = Integer.parseInt(et_voltaje.getText().toString());
        Integer amps = Integer.parseInt(et_resistencia.getText().toString());


        int curre = vol / amps;
        String resultc = String.valueOf(curre);
        tv_resultado.setText(String.format("%s%s", resultc, String.format(" A")));


    }
    //AMPS
    public void resistencia (View view) {

        Integer vol = Integer.parseInt(et_voltaje.getText().toString());
        Integer currt = Integer.parseInt(et_corriente.getText().toString());


        int amps = vol / currt;
        String resulta = String.valueOf(amps);
        tv_resultado.setText(String.format("%s%s", resulta, String.format(" Ω")));

    }
    //WATTS
    public void potencia (View view) {

        Integer voltage = Integer.parseInt(et_voltaje.getText().toString());
        Integer curr2 = Integer.parseInt(et_corriente.getText().toString());


        int volt = voltage * curr2;
        String resultp= String.valueOf(volt);
        tv_resultado.setText(String.format("%s%s", resultp, String.format(" W")));

    }
    //Boton eliminar
    public void delete (View view){


            et_voltaje.setText("");
            et_resistencia.setText("");
            et_corriente.setText("");
            et_potencia.setText("");
            tv_resultado.setText("0");
    }

    //button ohm's law
    public void leyohm (View view){
        Intent leyohm = new Intent(this, LeyohmActivity.class);
        startActivity(leyohm);
    }

    //button save
    public void guardardatos (View view){
        datos();
    }

    public void datos(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_formulas", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_ID, et_nombre.getText().toString());
        values.put(Utilidades.CAMPO_VOLTAJE, et_voltaje.getText().toString());
        values.put(Utilidades.CAMPO_RESISTENCIA, et_resistencia.getText().toString());
        values.put(Utilidades.CAMPO_CORRIENTE, et_corriente.getText().toString());
        values.put(Utilidades.CAMPO_POTENCIA, et_potencia.getText().toString());
        values.put(Utilidades.CAMPO_RESULTADO, tv_resultado.getText().toString());


        Toast.makeText(getApplicationContext(), "Formula registrada " , Toast.LENGTH_SHORT).show();
        db.close();
    }
        //button operation
    public void historial(View view){
        Intent historial = new Intent(this, HistorialActivity.class);
        startActivity(historial);
    }

        //button delete
    public void eliminar (View view) {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_formulas", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String Selection = Utilidades.CAMPO_ID+"=?";
        String[] argsel = {et_nombre.getText().toString()
        };

        db.delete(Utilidades.TABLA_FORMULAS, Selection, argsel);
        Toast.makeText(getApplicationContext(), "Se ha eliminado el calculo " , Toast.LENGTH_SHORT).show();


    }



}