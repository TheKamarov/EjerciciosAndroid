package com.example.comunicacionentreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceptorActivity extends AppCompatActivity {

    //creo las constantes con las claves para que otras actividades se puedan comunicar

    public static final String CLAVE_INFORMACION = "informacion";

    private TextView textViewInformacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptor);

        encontrarComponentesPorId();

        //traigo el intent

        Intent intent = getIntent();

        //traigo el bundle

        Bundle bundle = intent.getExtras();

        //Le pido lo que requiero al bundle y lo cargo en una variable

        String stringInformacion = bundle.getString(CLAVE_INFORMACION);

        //Le seteo al textView el valor de la informacion

        textViewInformacion.setText(stringInformacion);
    }

    private void encontrarComponentesPorId(){
        textViewInformacion = findViewById(R.id.ReceptorActivity_TextView_Informacion);
    }
}
