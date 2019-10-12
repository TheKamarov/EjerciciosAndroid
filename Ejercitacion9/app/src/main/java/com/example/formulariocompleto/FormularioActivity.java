package com.example.formulariocompleto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText edad;
    private EditText carrera;
    private EditText email;
    private Button enviar;
    private CheckBox torneos;
    private CheckBox meetups;
    private CheckBox asados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        nombre = findViewById(R.id.formulario_EditText_nombre);
        apellido = findViewById(R.id.formulario_EditText_apellido);
        edad = findViewById(R.id.formulario_EditText_edad);
        carrera = findViewById(R.id.formulario_EditText_carrera);
        email = findViewById(R.id.formulario_EditText_email);
        enviar = findViewById(R.id.formulario_Button_Enviar);
        torneos = findViewById(R.id.formulario_CheckBox_torneos);
        meetups = findViewById(R.id.formulario_CheckBox_meetups);
        asados = findViewById(R.id.formulario_CheckBox_Asados);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarDatosDelFormulario();
            }
        });

    }

    private void enviarDatosDelFormulario(){
        String stringNombre = nombre.getText().toString();
        String stringApellido = apellido.getText().toString();
        String stringEdad = edad.getText().toString();
        String stringCarrera = carrera.getText().toString();
        String stringEmail = email.getText().toString();

        if(stringNombre.equals("") || stringApellido.equals("") || stringEdad.equals("") || stringCarrera.equals("") || stringEmail.equals("")){
            Toast.makeText(FormularioActivity.this,"Falta rellenar campos", Toast.LENGTH_LONG).show();
        }else{
            if(stringNombre.length() <= 2 || stringApellido.length() <= 2){
                Toast.makeText(FormularioActivity.this,"El nombre y el apellido deben contener al menos 3 caracteres",Toast.LENGTH_LONG).show();
            }else{
                int intEdad = Integer.parseInt(stringEdad);
                if(intEdad < 7 || intEdad > 100){
                    Toast.makeText(FormularioActivity.this,"Debes ser mayor de 7 y menor de 100", Toast.LENGTH_LONG).show();
                }else{
                    if(stringCarrera.length() < 5){
                        Toast.makeText(FormularioActivity.this,"El campo carrera debe tener mas de 5 caracteres", Toast.LENGTH_LONG).show();
                    }else{
                        for(int i = 0; i < stringEmail.length(); i++){
                            char caracterArroba = '@';
                            char caracterDeEmail = stringEmail.charAt(i);
                            if(caracterDeEmail != caracterArroba){
                                Toast.makeText(FormularioActivity.this,"El email no es correcto",Toast.LENGTH_LONG).show();
                            }else{
                                enviarDatosAActivityEnvio();
                            }
                        }
                    }
                }
            }
        }
    }

    private void enviarDatosAActivityEnvio(){
        String stringNombre = nombre.getText().toString();
        String stringApellido = apellido.getText().toString();
        String stringEdad = edad.getText().toString();
        String stringCarrera = carrera.getText().toString();
        String stringEmail = email.getText().toString();
        boolean booleanMeetups = meetups.isChecked();
        boolean booleanTorneos = torneos.isChecked();
        boolean booleanAsados = asados.isChecked();

        Intent intent = new Intent(this,EnvioActivity.class);

        intent.putExtra("nombre", stringNombre);
        intent.putExtra("apellido", stringApellido);
        intent.putExtra("edad", stringEdad);
        intent.putExtra("carrera", stringCarrera);
        intent.putExtra("email", stringEmail);

        if(booleanMeetups){
            String meetups = "meetups";
            intent.putExtra("meetups", meetups);
        }
        if(booleanTorneos){
            String torneos = "torneos";
            intent.putExtra("torneos", torneos);
        }
        if(booleanAsados){
            String asados = "asados";
            intent.putExtra("asados", asados);
        }
        startActivity(intent);
    }
}


