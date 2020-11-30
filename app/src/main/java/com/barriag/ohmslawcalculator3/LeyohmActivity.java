package com.barriag.ohmslawcalculator3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LeyohmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leyohm);
        Toast.makeText(getApplicationContext(),"Formulas de ley de ohms",Toast.LENGTH_LONG).show();
    }

    public void volver (View view){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);

    }

}