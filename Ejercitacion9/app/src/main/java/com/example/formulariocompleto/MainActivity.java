package com.example.formulariocompleto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonComenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonComenzar = findViewById(R.id.main_Button_comenzar);

        buttonComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarAFormularioActivity();
            }
        });

    }

    private void cambiarAFormularioActivity(){
        Intent intent = new Intent(this,FormularioActivity.class);
        startActivity(intent);
    }
}
