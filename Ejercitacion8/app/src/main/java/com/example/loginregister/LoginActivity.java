package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    public static final String clave_username = "username";

    private TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textViewWelcome = findViewById(R.id.activityLogin_TextView_Welcome);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String welcomeUsername = bundle.getString(clave_username);
        textViewWelcome.setText("Welcome " + welcomeUsername + "!!!");
    }
}
