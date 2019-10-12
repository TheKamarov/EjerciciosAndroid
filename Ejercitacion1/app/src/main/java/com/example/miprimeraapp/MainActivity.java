package com.example.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textoObtenido;
    private Button botonAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoObtenido = findViewById(R.id.activity_main_editText_pantalla_uno);
        botonAceptar = findViewById(R.id.activity_main_button_pantalla_uno);

        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,textoObtenido.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
