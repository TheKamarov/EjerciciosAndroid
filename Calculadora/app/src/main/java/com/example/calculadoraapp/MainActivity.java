package com.example.calculadoraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewNumeroMostrado;
    private Button botonReiniciarCalculo;
    private Button botonModificarPositividadONegatividadDelResultado;
    private Button botonDivideElResultadoPorDiez;
    private Button botonDivideElResultado;
    private Button botonNumeroSiete;
    private Button botonNumeroOcho;
    private Button botonNumeroDiez;
    private Button botonMultiplicaElResultado;
    private Button botonNumeroCuatro;
    private Button botonNumeroCinco;
    private Button botonNumeroSeis;
    private Button botonRestarElResultado;
    private Button botonNumeroUno;
    private Button botonNumeroDos;
    private Button botonNumeroTres;
    private Button botonSumarElResultado;
    private Button botonNumeroCero;
    private Button botonNumeroDecimal;
    private Button botonMostrarElResultado;
    private Double numeroGuardadoParaOperar;
    private Double numeroGuardadoParaOperarDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewNumeroMostrado = findViewById(R.id.activityMain_textView_resultado);
        botonReiniciarCalculo = findViewById(R.id.activityMain_button_reiniciarCalculo);
        botonModificarPositividadONegatividadDelResultado = findViewById(R.id.activityMain_button_modificarPositividadONegatividadDelResultado);
        botonDivideElResultadoPorDiez = findViewById(R.id.activityMain_button_divideElResultadoPorDiez);
        botonDivideElResultado = findViewById(R.id.activityMain_button_divideElResultado);
        botonNumeroSiete = findViewById(R.id.activityMain_button_numeroSiete);
        botonNumeroOcho = findViewById(R.id.activityMain_button_numeroOcho);
        botonNumeroDiez = findViewById(R.id.activityMain_button_numeroDiez);
        botonMultiplicaElResultado = findViewById(R.id.activityMain_button_multiplicaElResultado);
        botonNumeroCuatro = findViewById(R.id.activityMain_button_numeroCuatro);
        botonNumeroCinco = findViewById(R.id.activityMain_button_numeroCinco);
        botonNumeroSeis = findViewById(R.id.activityMain_button_numeroSeis);
        botonRestarElResultado = findViewById(R.id.activityMain_button_restarElResultado);
        botonNumeroUno = findViewById(R.id.activityMain_button_numeroUno);
        botonNumeroDos = findViewById(R.id.activityMain_button_numeroDos);
        botonNumeroTres = findViewById(R.id.activityMain_button_numeroTres);
        botonSumarElResultado = findViewById(R.id.activityMain_button_sumarElResultado);
        botonNumeroCero = findViewById(R.id.activityMain_button_numeroCero);
        botonNumeroDecimal = findViewById(R.id.activityMain_button_numeroDecimal);
        botonMostrarElResultado = findViewById(R.id.activityMain_button_mostrarElResultado);
        numeroGuardadoParaOperar = 0.0;
        numeroGuardadoParaOperarDos = 0.0;

        textViewNumeroMostrado.setText("0");


        botonReiniciarCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroGuardadoParaOperar = 0.0;
                numeroGuardadoParaOperarDos = 0.0;
                textViewNumeroMostrado.setText("0");
            }
        });

        botonModificarPositividadONegatividadDelResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transformarElTextViewResultadoAUnNumeroNegativoOPositivo();
            }
        });
    }

    private void transformarElTextViewResultadoAUnNumeroNegativoOPositivo(){
        String numeroTransformadoString = textViewNumeroMostrado.getText().toString();
        double numeroTransformado = Double.parseDouble(numeroTransformadoString);
        if(numeroTransformado < 0){
            numeroTransformado = numeroTransformado * -1;
            numeroTransformadoString = String.valueOf(numeroTransformado);
            textViewNumeroMostrado.setText(numeroTransformadoString);
        }else if(numeroTransformado == 0){
            if(numeroTransformadoString.equals("-0")){
                textViewNumeroMostrado.setText("0");
            }else{
                numeroTransformadoString = "-" + textViewNumeroMostrado.getText();
                textViewNumeroMostrado.setText(numeroTransformadoString);
            }
        }else{
            int numeroTransformadoInteger = Integer.parseInt(numeroTransformadoString);
            numeroTransformadoInteger = numeroTransformadoInteger * -1;
            numeroTransformadoString = String.valueOf(numeroTransformadoInteger);
            textViewNumeroMostrado.setText(numeroTransformadoString);
        }
    }

}
