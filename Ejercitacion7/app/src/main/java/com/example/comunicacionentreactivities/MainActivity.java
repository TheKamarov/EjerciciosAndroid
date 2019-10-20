package com.example.comunicacionentreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInformacion;
    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encontrarComponentesPorId();

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //utilizo el metodo anteriormente creado para generar un codigo mucho mas limpio y entendible
                cambiarDeActivity();
            }
        });
    }

    private void encontrarComponentesPorId(){
        editTextInformacion = findViewById(R.id.MainActivity_EditText_Informacion);
        buttonEnviar = findViewById(R.id.MainActivity_Button_Enviar);
    }

    private void cambiarDeActivity(){

        //guardo el valor del editText

        String stringInformacion = editTextInformacion.getText().toString();

        //creo el intent a la nueva actividad(El pasaje)
        //En el intent se debe indicar el punto de salida y el de llegada

        Intent intent = new Intent(this,ReceptorActivity.class);

        //creo el bundle (La valija)
        //El bundle va a llevar la informacion que le pasemos

        Bundle bundle = new Bundle();

        //le guardo los valores al bundle (cargo la valija)
        //En este paso hay que ir a la actividad que va a llegar la informacion para colocarle una
        //clave asi se puede comunicar

        bundle.putString(ReceptorActivity.CLAVE_INFORMACION, stringInformacion);

        //Le ponemos el bundle al intent (Le cargamos la valija al pasaje para que pueda viajar tambien)

        intent.putExtras(bundle);

        //Arrancamos la nueva activity

        startActivity(intent);
    }
}
