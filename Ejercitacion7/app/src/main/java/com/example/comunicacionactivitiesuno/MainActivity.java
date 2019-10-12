package com.example.comunicacionactivitiesuno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText edad;
    private Button mandar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.activityMain_EditText_Nombre);
        apellido = findViewById(R.id.activityMain_EditText_Apellido);
        edad = findViewById(R.id.activityMain_EditText_Edad);
        mandar = findViewById(R.id.activityMain_Button_Mandar);

        mandar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarDeActivity();
            }
        });


    }
    private void cambiarDeActivity(){
        //guardo el valor del username
        String apellidoString = apellido.getText().toString();
        String nombreString = nombre.getText().toString();
        String edadString = edad.getText().toString();
        // creo el intent a la nueva actividad (el pasaje)
        Intent intent = new Intent(this,ReceptorActivity.class);
        // creo el bundle (la valija)
        Bundle bundle = new Bundle();

        intent.putExtra("nombre", nombreString);
        intent.putExtra("apellido", apellidoString);
        intent.putExtra("edad", edadString);

        //arrancamos la nueva activity
        startActivity(intent);
    }

}
