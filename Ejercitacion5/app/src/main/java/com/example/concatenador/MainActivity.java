package com.example.concatenador;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textoUno;
    private EditText textoDos;
    private Button botonConcatenador;
    private TextView depositoTexto;
    private String textosUnidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoUno = findViewById(R.id.activity_main_editText_pantalla_uno);
        textoDos = findViewById(R.id.activity_main_segundo_editText_pantalla_uno);
        botonConcatenador = findViewById(R.id.activity_main_button_pantalla_uno);
        depositoTexto = findViewById(R.id.activity_main_textView_pantalla_uno);

        botonConcatenador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarATextosUnidos(textoUno);
                agregarATextosUnidos(textoDos);
            }
        });
    }

    private void agregarATextosUnidos(EditText unEditText){
        if(textosUnidos == null){
            textosUnidos = unEditText.getText().toString();
        }else{
            textosUnidos = textosUnidos + " " + unEditText.getText().toString();
        }
        depositoTexto.setText(textosUnidos);
    }
}
