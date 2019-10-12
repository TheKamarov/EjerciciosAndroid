package com.example.formulariodenetlix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class InicioActivity extends AppCompatActivity {

    public static final String CLAVE_EMAIL = "email";
    public static final String CLAVE_PASSWORD = "password";

    private TextView textViewEmail;
    private TextView textViewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        textViewEmail = findViewById(R.id.inicioActivity_textView_email);
        textViewPassword = findViewById(R.id.inicioActivity_textView_password);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String stringEmail = bundle.getString(CLAVE_EMAIL);
        String stringPassword = bundle.getString(CLAVE_PASSWORD);
        textViewEmail.setText(stringEmail);
        textViewPassword.setText(stringPassword);
    }
}
