package com.example.sumadorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView numero;
    private Button botonSumar;
    private Button botonRestar;
    private Integer contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = findViewById(R.id.activity_main_textView_pantalla_uno);
        botonSumar = findViewById(R.id.activity_main_buttonSumar_pantalla_uno);
        botonRestar = findViewById(R.id.activity_main_buttonRestar_pantalla_uno);

        contador = 0;

        botonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador ++;
                cambiarVista();
            }
        });

        botonRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador --;
                cambiarVista();
            }
        });
    }

    private void cambiarVista(){
        numero.setText(contador.toString());
    }
}
