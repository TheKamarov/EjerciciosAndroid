package com.example.formulariodenetlix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarseActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextApellido;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private Button buttonRegistrarse;
    private Button buttonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        editTextNombre = findViewById(R.id.registrarseActivity_editText_nombre);
        editTextApellido = findViewById(R.id.registrarseActivity_editText_apellido);
        editTextEmail = findViewById(R.id.registrarseActivity_editText_email);
        editTextPassword = findViewById(R.id.registrarseActivity_editText_password);
        editTextConfirmPassword = findViewById(R.id.registrarseActivity_editText_ConfirmPassword);
        buttonRegistrarse = findViewById(R.id.registrarseActivity_button_registrarse);
        buttonVolver = findViewById(R.id.registrarseActivity_button_volver);

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarAActivityMain();
            }
        });

        buttonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtrarLosCamposYcambiarAActivityMain();
            }
        });
    }

    private void cambiarAActivityMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    private void filtrarLosCamposYcambiarAActivityMain(){
        if(editTextNombre.getText().toString().length() <= 1 ){
            Toast.makeText(RegistrarseActivity.this,"El nombre debe contener al menos dos letras", Toast.LENGTH_SHORT).show();
            return;
        }
        if(editTextApellido.getText().toString().length() <= 1){
            Toast.makeText(RegistrarseActivity.this,"El apellido debe contener al menos dos letras", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!editTextEmail.getText().toString().contains("@")){
            Toast.makeText(RegistrarseActivity.this,"El email no es valido", Toast.LENGTH_SHORT).show();
            return;
        }
        if(editTextPassword.getText().toString().length() < 4 ){
            Toast.makeText(RegistrarseActivity.this,"La password debe contener al menos cinco letras", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!editTextConfirmPassword.getText().toString().equals(editTextPassword.getText().toString())){
            Toast.makeText(RegistrarseActivity.this,"Las passwords son distintas", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(RegistrarseActivity.this,"El registro a sido confirmado", Toast.LENGTH_SHORT).show();
        cambiarAActivityMain();
    }

}
