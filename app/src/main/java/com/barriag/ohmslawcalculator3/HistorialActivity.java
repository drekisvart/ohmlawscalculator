package com.barriag.ohmslawcalculator3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.barriag.ohmslawcalculator3.entidades.ConexionSQLiteHelper;
import com.barriag.ohmslawcalculator3.entidades.Formulas;
import com.barriag.ohmslawcalculator3.utlidades.Utilidades;

import java.util.ArrayList;

import static android.widget.AdapterView.*;

public class HistorialActivity extends AppCompatActivity {
    Spinner comboformulas;
    TextView txt_voltaje;
    TextView txt_resistencia;
    TextView txt_corriente;
    TextView txt_potencia;
    TextView txt_resultado;
    ArrayList<String> listaformulas;
    ArrayList<Formulas> formulaslist;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "db_formulas", null, 1);
        comboformulas = findViewById(R.id.comboformulas);
        txt_voltaje = findViewById(R.id.txt_voltaje);
        txt_resistencia = findViewById(R.id.txt_resistencia);
        txt_corriente = findViewById(R.id.txt_corriente);
        txt_potencia = findViewById(R.id.txt_potencia);
        txt_resultado = findViewById(R.id.txt_resultado);

        mostrarhistorial();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaformulas);
        comboformulas.setAdapter(adaptador);

        comboformulas.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long idl) {
                if (position != 0){
                    txt_voltaje.setText(formulaslist.get(position-1).getVoltaje().toString() + " V");
                    txt_resistencia.setText(formulaslist.get(position-1).getResistencia().toString()+ " Ω");
                    txt_corriente.setText(formulaslist.get(position-1).getCorriente().toString()+ " A");
                    txt_potencia.setText(formulaslist.get(position-1).getPotencia().toString()+ " W");
                    txt_resultado.setText(formulaslist.get(position-1).getResultado().toString());
                }else{

                    txt_voltaje.setText("");
                    txt_resistencia.setText("");
                    txt_corriente.setText("");
                    txt_potencia.setText("");
                    txt_resultado.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void mostrarhistorial() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Formulas form = null;
        formulaslist = new ArrayList<Formulas>();


        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_FORMULAS, null);

        while (cursor.moveToNext()) {

            form = new Formulas();
            form.setId(cursor.getString(0));
            form.setVoltaje(cursor.getInt(1));
            form.setResistencia(cursor.getInt(2));
            form.setCorriente(cursor.getInt(3));
            form.setPotencia(cursor.getInt(4));
            form.setResultado(cursor.getInt(5));

            Log.i("id", form.getId());
            Log.i("voltaje", form.getVoltaje().toString());
            Log.i("resistencia", form.getResistencia().toString());
            Log.i("corriente", form.getCorriente().toString());
            Log.i("potencia", form.getPotencia().toString());
            Log.i("resultado", form.getResultado().toString());

            formulaslist.add(form);
        }
        obtenerhistorial();
    }

    private void obtenerhistorial() {
        listaformulas = new ArrayList<String>();
        listaformulas.add("Seleccione");

        for (int i = 0; i < formulaslist.size(); i++) {
            listaformulas.add(formulaslist.get(i).getId());

            txt_corriente.setText("A");
        }
    }
    public void volver2 (View view){
        Intent volver2 = new Intent(this, MainActivity.class);
        startActivity(volver2);

    }


}