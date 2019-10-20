package com.example.comunicacionentreactivitiesdos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextApellido;
    private EditText editTextEdad;
    private Button buttonMandar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encontrarLosComponentesPorId();

        buttonMandar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarDeActivity();
            }
        });

    }

    private void encontrarLosComponentesPorId(){
        editTextNombre = findViewById(R.id.MainActivity_EditText_Nombre);
        editTextApellido = findViewById(R.id.MainActivity_EditText_Apellido);
        editTextEdad = findViewById(R.id.MainActivity_EditText_Edad);
        buttonMandar = findViewById(R.id.MainActivity_Button_Mandar);
    }

    private void cambiarDeActivity(){

        //Guardo los valores en variables

        String stringNombre = editTextNombre.getText().toString();
        String stringApellido = editTextApellido.getText().toString();
        String stringEdad = editTextEdad.getText().toString();

        //Creo el intent (El pasaje)
        //En el intent se debe indicar el punto de salida y de llegada

        Intent intent = new Intent(MainActivity.this,ReceptorActivity.class);

        //Creo el bundle (La valija)
        //El bundle va a llevar la informacion que le cargamos a la otra activity

        Bundle bundle = new Bundle();

        //Le cargo los valores al bundle (cargo la valija)
        //En este paso hay que agregarle una clave para poder pasarlo a la otra activity

        bundle.putString(ReceptorActivity.CLAVE_NOMBRE, stringNombre);
        bundle.putString(ReceptorActivity.CLAVE_APELLIDO, stringApellido);
        bundle.putString(ReceptorActivity.CLAVE_EDAD, stringEdad);

        //Le ponemos el bundle al intent (Le cargamos la valija al pasaje para que viaje con el tambien)

        intent.putExtras(bundle);

        //Arrancamos la nueva activity

        startActivity(intent);
    }
}
