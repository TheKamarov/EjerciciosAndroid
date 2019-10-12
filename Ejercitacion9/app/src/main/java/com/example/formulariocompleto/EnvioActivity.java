package com.example.formulariocompleto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EnvioActivity extends AppCompatActivity {

    private TextView textViewNombre;
    private TextView textViewApellido;
    private TextView textViewEmail;
    private TextView textViewEdad;
    private TextView textViewCarrera;
    private TextView textViewOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio);

        textViewNombre = findViewById(R.id.envio_textView_nombre);
        textViewApellido = findViewById(R.id.envio_textView_apellido);
        textViewEmail = findViewById(R.id.envio_textView_email);
        textViewEdad = findViewById(R.id.envio_textView_edad);
        textViewCarrera = findViewById(R.id.envio_textView_carrera);
        textViewOpciones = findViewById(R.id.envio_textView_opciones);

        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");
        String edad = getIntent().getStringExtra("edad");
        String email = getIntent().getStringExtra("email");
        String carrera = getIntent().getStringExtra("carrera");
        String meetups = getIntent().getStringExtra("meetups");
        String torneos = getIntent().getStringExtra("torneos");
        String asados = getIntent().getStringExtra("asados");

        if(meetups != null && torneos != null && asados != null){
            String opciones = meetups + " y " + torneos + " y " + asados;
            textViewOpciones.setText(opciones);
        }else if(meetups != null && torneos != null){
            String opciones = meetups + " y " + torneos;
            textViewOpciones.setText(opciones);
        }else if(torneos != null && asados != null){
            String opciones = torneos + " y " + asados;
            textViewOpciones.setText(opciones);
        }else if(meetups != null && asados != null){
            String opciones = meetups + " y " + asados;
            textViewOpciones.setText(opciones);
        }else if(meetups != null){
            textViewOpciones.setText(meetups);
        }else if(asados != null){
            textViewOpciones.setText(asados);
        }else if(torneos != null){
            textViewOpciones.setText(torneos);
        }else{
            String opciones = "No eligio ninguna";
            textViewOpciones.setText(opciones);
        }

        textViewNombre.setText(nombre);
        textViewApellido.setText(apellido);
        textViewEdad.setText(edad);
        textViewEmail.setText(email);
        textViewCarrera.setText(carrera);

    }
}
