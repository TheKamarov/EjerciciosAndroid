package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private Button buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUsername = findViewById(R.id.activityRegister_EditText_Username);
        editTextPassword = findViewById(R.id.activityRegister_EditText_Password);
        editTextConfirmPassword = findViewById(R.id.activityRegister_EditText_ConfirmPassword);
        buttonRegister = findViewById(R.id.activityRegister_Button_Register);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringPassword = editTextPassword.getText().toString();
                String stringConfirmPassword = editTextConfirmPassword.getText().toString();

                if(stringPassword.equals(stringConfirmPassword)){
                    cambiarAActivityMain();
                }else{
                    Toast.makeText(RegisterActivity.this,"La password no coincide",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void cambiarAActivityMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
