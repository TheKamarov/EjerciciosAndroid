package com.example.loginregisterfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements FragmentWelcome.MuestraDeLogin {

    //creamos las constantes con las claves para que otras actividades se puedan comunicar
    public static final String CLAVE_USERNAME = "claveUsername";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mostrarLogin(reciboLaInformacion());

    }

    private String reciboLaInformacion(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String stringUsername = bundle.getString(CLAVE_USERNAME);
        return stringUsername;
    }

    @Override
    public void mostrarLogin(String stringUsername) {
        Bundle bundle = new Bundle();
        bundle.putString(CLAVE_USERNAME,stringUsername);
        FragmentWelcome fragmentWelcome = new FragmentWelcome();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentWelcome.setArguments(bundle);
        fragmentTransaction.add(R.id.WelcomeActivity_FrameLayout_ContenedorDeFragments,fragmentWelcome);
        fragmentTransaction.commit();
    }
}
