package com.example.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textoObtenido;
    private Button botonAceptar;
    private LinearLayout linearLayout;
    private TextView titulo;
    private Button botonCambiarDeColorTextView;
    private Button botonCambiarContenidoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoObtenido = findViewById(R.id.activity_main_editText_pantalla_uno);
        botonAceptar = findViewById(R.id.activity_main_button_pantalla_uno);
        linearLayout = findViewById(R.id.activity_main_linearLayout_pantalla_uno);
        titulo = findViewById(R.id.activity_main_textView_pantalla_uno);
        botonCambiarDeColorTextView = findViewById(R.id.activity_main_button_dos_pantalla_uno);
        botonCambiarContenidoTextView = findViewById(R.id.activity_main_button_tres_pantalla_uno);

        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,textoObtenido.getText().toString(),Toast.LENGTH_LONG).show();
                linearLayout.setBackgroundColor(Color.rgb(150,54,53));
            }
        });

        botonCambiarDeColorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titulo.setTextColor(Color.rgb(50,50,100));
            }
        });

        botonCambiarContenidoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titulo.setText("Presionaste el boton");
            }
        });


    }
}
