package com.example.comunicacionentreactivitiesdos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceptorActivity extends AppCompatActivity {

    //Creo las constantes para que otras actividades se puedan comunicar

    public static final String CLAVE_NOMBRE = "nombre";
    public static final String CLAVE_APELLIDO = "apellido";
    public static final String CLAVE_EDAD = "edad";

    private TextView textViewNombreIngresado;
    private TextView textViewApellidoIngresado;
    private TextView textViewEdadIngresada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptor);

        encontrarLosComponentesPorId();

        //traigo el intent

        Intent intent = getIntent();

        //Traigo el bundle

        Bundle bundle = intent.getExtras();

        //Le pido al bundle lo que necesito y lo cargo en variables locales

        String stringNombreRecibido = bundle.getString(CLAVE_NOMBRE);
        String stringApellidoRecibido = bundle.getString(CLAVE_APELLIDO);
        String stringEdadRecibida = bundle.getString(CLAVE_EDAD);

        //Le seteo la informacion a los TextView correspondientes

        textViewNombreIngresado.setText(stringNombreRecibido);
        textViewApellidoIngresado.setText(stringApellidoRecibido);
        textViewEdadIngresada.setText(stringEdadRecibida);
    }

    private void encontrarLosComponentesPorId(){
        textViewNombreIngresado = findViewById(R.id.ReceptorActivity_TextView_NombreRecibido);
        textViewApellidoIngresado = findViewById(R.id.ReceptorActivity_TextView_ApellidoRecibido);
        textViewEdadIngresada = findViewById(R.id.ReceptorActivity_TextView_EdadRecibido);
    }
}
