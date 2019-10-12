package com.example.comunicacionactivitiesuno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ReceptorActivity extends AppCompatActivity {

    private TextView nombreIngresado;
    private TextView apellidoIngresado;
    private TextView edadIngresado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptor);

        nombreIngresado = findViewById(R.id.activityMain_TextView_NombreIngresado);
        apellidoIngresado = findViewById(R.id.activityMain_TextView_ApellidoIngresado);
        edadIngresado = findViewById(R.id.activityMain_TextView_EdadIngresado);


        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");
        String edad = getIntent().getStringExtra("edad");
        // le seteamos al textView
        nombreIngresado.setText(nombre);
        apellidoIngresado.setText(apellido);
        edadIngresado.setText(edad);

    }
}
