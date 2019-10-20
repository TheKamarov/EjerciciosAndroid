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

    //creo los objeto que he puesto en el xml para utilizarlos

    //Una buena practica es que siempre que crees un objeto pogas de nombre el tipo de objeto y
    //luego la funcionalidad, Ejemplo: buttonEnviarNombre

    private Button buttonNombre;
    private Button buttonCambiarColorTextView;
    private Button buttonCambiarContenidoTextView;
    private EditText editTextNombre;
    private LinearLayout linearLayoutMainActivity;
    private TextView textViewNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Luego de crear los objetos hay que encontrarlos con los del XML por el ID

        buttonNombre = findViewById(R.id.MainActivity_Button_EnviarNombre);
        buttonCambiarColorTextView = findViewById(R.id.MainActivity_Button_CambiarColorTextView);
        buttonCambiarContenidoTextView = findViewById(R.id.MainActivity_Button_CambiarContenidoTextView);
        editTextNombre = findViewById(R.id.MainActivity_EditText_Nombre);
        linearLayoutMainActivity = findViewById(R.id.MainActivity_LinearLayout);
        textViewNombre = findViewById(R.id.MainActivity_TextView_Nombre);

        //Le doy al boton la accion que tiene que hacer al ser clikeado

        buttonNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creo un String para que contenga lo que pongan dentro de el editText

                String stringContenidoDelEditTextNombre = editTextNombre.getText().toString();

                //El fondo del LinearLayout va a cambiar

                linearLayoutMainActivity.setBackgroundColor(Color.rgb(100,50,200));

                //Creo un tost, que es el que muestra por pantalla un string , en este caso muestra
                //el contenido del string anteriormente creado
                //Hay que tener en cuanta que si o si para que se muestre al final se debe poner .show()

                Toast.makeText(MainActivity.this, stringContenidoDelEditTextNombre, Toast.LENGTH_SHORT).show();
            }
        });

        buttonCambiarColorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Cambio el color del TextView

                textViewNombre.setTextColor(Color.rgb(0,245,0));
            }
        });

        buttonCambiarContenidoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cambio el contenido del TextView con el que pasan por el EditText

                String stringContenidoDelEditTextNombre = editTextNombre.getText().toString();

                textViewNombre.setText(stringContenidoDelEditTextNombre);
            }
        });
    }
}
