package com.barriag.ohmslawcalculator3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText etn_voltaje;
    EditText etn_corriente;
    EditText etn_resistencia;
    EditText etn_potencia;
    TextView tv_resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn_voltaje = findViewById(R.id.etn_voltaje);
        etn_corriente = findViewById(R.id.etn_corriente);
        etn_resistencia = findViewById(R.id.etn_resistencia);
        etn_potencia = findViewById(R.id.etn_potencia);
        tv_resultado = findViewById(R.id.tv_resultado);
    }
    //VOLTAJE
    public void voltaje (View view) {

        Integer curr = Integer.parseInt(etn_corriente.getText().toString());
        Integer amps = Integer.parseInt(etn_resistencia.getText().toString());

        int volt = curr * amps;
        String resultv = String.valueOf(volt);
        tv_resultado.setText(resultv);

        if(Checkno(etn_corriente.getText().toString())){
            Toast.makeText(getApplicationContext(), "Solo numeros", Toast.LENGTH_SHORT).show();
        }
        if(Checkno(etn_resistencia.getText().toString())){
            Toast.makeText(getApplicationContext(), "Solo numeros", Toast.LENGTH_SHORT).show();
        }

    }
    //CORRIENTE
    public void corriente (View view) {

        Integer vol = Integer.parseInt(etn_voltaje.getText().toString());
        Integer amps = Integer.parseInt(etn_resistencia.getText().toString());


        int curre = vol / amps;
        String resultc = String.valueOf(curre);
        tv_resultado.setText(resultc);


    }
    //AMPS
    public void resistencia (View view) {

        Integer vol = Integer.parseInt(etn_voltaje.getText().toString());
        Integer currt = Integer.parseInt(etn_corriente.getText().toString());


        int amps = vol / currt;
        String resulta = String.valueOf(amps);
        tv_resultado.setText(resulta);

    }
    //WATTS
    public void potencia (View view) {

        Integer voltage = Integer.parseInt(etn_voltaje.getText().toString());
        Integer curr2 = Integer.parseInt(etn_corriente.getText().toString());


        int volt = voltage * curr2;
        String resultp= String.valueOf(volt);
        tv_resultado.setText(resultp);

    }
    //Boton eliminar
    public void delete (View view){


            etn_voltaje.setText("");
            etn_resistencia.setText("");
            etn_corriente.setText("");
            etn_potencia.setText("");
            tv_resultado.setText("0");
    }
    public void leyohm (View view){
        Intent leyohm = new Intent(this, LeyohmActivity.class);
        startActivity(leyohm);
    }

    public Boolean Checkno(String sn){
       Boolean check = false;

       String no = "\\d*\\.?\\d+";
       CharSequence inputStr = sn;
       Pattern pte = Pattern.compile(no,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pte.matcher(inputStr);
        if (matcher.matches()){
            check = true;
        }
        return check;
    }


}