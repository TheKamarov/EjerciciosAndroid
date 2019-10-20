package com.example.sumadorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewNumero;
    private Button buttonSumar;
    private Button buttonRestar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buscarPorIdLosComponentes();

        buttonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Lo que hago es hacer un parseo de String a Integer para poder luego modificar el
                //valor del mismo

                int intNumero = Integer.parseInt(textViewNumero.getText().toString());

                //Le sumo uno cada ves que el boton se aprete a la variable intNumero

                intNumero++;

                //Creo una variable de tipo String donde se va a depositar el valor del numero ya
                //sumado
                //Lo que hago es transformar un int a un String

                String stringNumeroFinal = String.valueOf(intNumero);

                //por ultimo seteo el textViewNumero con el valor obtenido

                textViewNumero.setText(stringNumeroFinal);
            }
        });

        buttonRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Lo que hago es hacer un parseo de String a Integer para poder luego modificar el
                //valor del mismo

                int intNumero = Integer.parseInt(textViewNumero.getText().toString());

                //Le resto uno cada ves que el boton se aprete a la variable intNumero

                intNumero--;

                //Creo una variable de tipo String donde se va a depositar el valor del numero ya
                //sumado
                //Lo que hago es transformar un int a un String

                String stringNumeroFinal = String.valueOf(intNumero);

                //por ultimo seteo el textViewNumero con el valor obtenido

                textViewNumero.setText(stringNumeroFinal);
            }
        });

    }

    //Creo un metodo que solo se va a usar dentro de esta activity que busca todos los componentes
    //por id
    //Lo hago asi para tener un codigo mucho mas limpio y visible
    //Calquier modificacion que le deba hacer a alguna busqueda por id o alguna cosa que se deba
    //agregar lo modifico en este simple metodo y no debo tocar el onCreate

    private void buscarPorIdLosComponentes(){
        textViewNumero = findViewById(R.id.MainActivity_TextView_Numero);
        buttonSumar = findViewById(R.id.MainActivity_Button_Sumar);
        buttonRestar = findViewById(R.id.MainActivity_Button_Restar);
    }
}
