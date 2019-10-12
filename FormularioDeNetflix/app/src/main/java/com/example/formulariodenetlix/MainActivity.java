package com.example.formulariodenetlix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonIniciarSesion;
    private Button buttonRegistrarse;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.activityMain_editText_email);
        editTextPassword = findViewById(R.id.activityMain_editText_password);
        buttonIniciarSesion = findViewById(R.id.activityMain_button_iniciarSesion);
        buttonRegistrarse = findViewById(R.id.activityMain_button_registrarse);

        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtrarCamposYCambiarAActivityInicio();
            }
        });

        buttonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarAActivityRegistrarse();
            }
        });
    }

    private void cambiarAActivityRegistrarse(){
        Intent intent = new Intent(this,RegistrarseActivity.class);
        startActivity(intent);
    }

    private void cambiarAActivityInicio(){
        String stringEmail = editTextEmail.getText().toString();
        String stringPassword = editTextPassword.getText().toString();
        Intent intent = new Intent(this,InicioActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(InicioActivity.CLAVE_EMAIL, stringEmail);
        bundle.putString(InicioActivity.CLAVE_PASSWORD, stringPassword);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void filtrarCamposYCambiarAActivityInicio(){
        if(!editTextEmail.getText().toString().contains("@") || !editTextEmail.getText().toString().contains(".com")){
            Toast.makeText(this,"El email no es valido", Toast.LENGTH_SHORT).show();
            return;
        }
        if(editTextPassword.getText().toString().length() < 1){
            Toast.makeText(this,"El password no es valido", Toast.LENGTH_SHORT).show();
            return;
        }
        cambiarAActivityInicio();
    }
}
