package com.example.digitalhouse.floatbuttonbase;



import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private FragmentManager miFragmentManager;
    private TextInputEditText textInputEditTextMensaje;
    private TextInputEditText textInputEditTextRegalos;
    private TextInputLayout textInputLayoutMensaje;
    private TextInputLayout textInputLayoutRegalos;
    private FloatingActionButton floatingActionButtonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEditTextMensaje = findViewById(R.id.mainActivity_textInputEditText_mensaje);
        textInputEditTextRegalos = findViewById(R.id.mainActivity_textInputEditText_regalos);
        textInputLayoutMensaje = findViewById(R.id.mainActivity_textInputLayout_mensaje);
        textInputLayoutRegalos = findViewById(R.id.mainActivity_textInputLayout_regalos);
        floatingActionButtonSend = findViewById(R.id.mainActivity_floatingActionButton_send);

        floatingActionButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarLosCamposYAgregarElFragment();
            }
        });
    }

    private void verificarLosCamposYAgregarElFragment(){
        if(textInputEditTextMensaje.length() == 0){
            textInputLayoutMensaje.setError("Porfavor complete el campo mensaje");
        }else{
            textInputLayoutMensaje.setError(null);
            enviarLosDatosASantaFragment();
            agregarElFragment();
        }
    }

    private void agregarElFragment(){
        miFragmentManager = getSupportFragmentManager();

        SantaFragment santaFragment = new SantaFragment();

        FragmentTransaction unaTransaccion = miFragmentManager.beginTransaction();
        unaTransaccion.replace(R.id.contenedorDeFragments, santaFragment);
        unaTransaccion.commit();
    }

    private void enviarLosDatosASantaFragment(){
        Bundle datos = new Bundle();
        datos.putString("mensaje",textInputEditTextMensaje.getText().toString());
        if(textInputEditTextRegalos.toString().length() == 0){
           datos.putString("noPidioRegalos", "No pidio regalos");
        }else{
            datos.putString("regalos", textInputEditTextRegalos.getText().toString());
        }
        SantaFragment newFragment = new SantaFragment();
        newFragment.setArguments(datos);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorDeFragments, newFragment);
        fragmentTransaction.commit();
    }
}
