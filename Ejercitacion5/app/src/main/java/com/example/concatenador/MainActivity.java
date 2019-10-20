package com.example.concatenador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTextUno;
    private EditText editTextTextDos;
    private Button buttonUnirTextos;
    private TextView textViewRepositorioDeTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buscarComponentesPorId();

        buttonUnirTextos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringTextoUno = editTextTextUno.getText().toString();
                String stringTextoDos = editTextTextDos.getText().toString();

                String stringTextosUnidos = stringTextoUno + stringTextoDos;

                textViewRepositorioDeTexto.setText(stringTextosUnidos);
            }
        });
    }

    private void buscarComponentesPorId(){
        editTextTextUno = findViewById(R.id.MainActivity_EditText_TextoUno);
        editTextTextDos = findViewById(R.id.MainActivity_EditText_TextoDos);
        buttonUnirTextos = findViewById(R.id.MainActivity_Button_Unir);
        textViewRepositorioDeTexto = findViewById(R.id.MainActivity_TextView_RepositorioDeTexto);
    }
}
