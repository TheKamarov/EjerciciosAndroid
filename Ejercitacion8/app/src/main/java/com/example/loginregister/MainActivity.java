package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private Button buttonLogin;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.activityMain_EditText_Username);
        buttonLogin = findViewById(R.id.activityMain_Button_Login);
        buttonRegister = findViewById(R.id.activityMain_Button_Register);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarALoginActivity();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarARegisterActivity();
            }
        });

    }

    private void cambiarALoginActivity(){
        String stringUsername = editTextUsername.getText().toString();
        Intent intent = new Intent(this,LoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(LoginActivity.clave_username,stringUsername);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void cambiarARegisterActivity(){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
