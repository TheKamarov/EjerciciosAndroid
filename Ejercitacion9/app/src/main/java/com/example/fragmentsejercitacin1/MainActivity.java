package com.example.fragmentsejercitacin1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonCambiarRojo;
    private Button buttonCambiarVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encontrarLosComponentesPorId();

        //uso el metodo aca para que apenas inicie la app aparesca con un fragment

        pegarFragment(new FragmentFondoVerde());

        //cpmfiguro el boton para que cambie al fragment rojo

        buttonCambiarRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //instancio el fragment
                FragmentFondoRojo fragmentFondoRojo = new FragmentFondoRojo();

                //llamo al metodo pegar fragmenr donde agrupe el conportamiento de hacer una transaccion
                pegarFragment(fragmentFondoRojo);
            }
        });

        buttonCambiarVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //instancio el fragment
                FragmentFondoVerde fragmentFondoVerde = new FragmentFondoVerde();

                //llamo al metodo pegar fragmenr donde agrupe el conportamiento de hacer una transaccion
                pegarFragment(fragmentFondoVerde);
            }
        });
    }

    private void encontrarLosComponentesPorId(){
        buttonCambiarRojo = findViewById(R.id.MainActivity_Button_CargarFragmentRojo);
        buttonCambiarVerde = findViewById(R.id.MainActivity_Button_CargarFragmentVerde);
    }

    private void pegarFragment(Fragment fragment){

        //busco el fragment manager

        FragmentManager fragmentManager = getSupportFragmentManager();

        //Creo una transaccion

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Especifico los detalles de la transacion
        //Aca debes poner donde se va a depositar el fragment y cual es el fragment

        fragmentTransaction.add(R.id.MainActivity_FrameLayout_RepositorioDeFragments,fragment,null);

        //Recuerdo la transaccion para poder ir para atras
        //Cuando el user aprete el boton de ir para atras se le pondria el fragment que antes estuvo

        fragmentTransaction.addToBackStack(null);

        //comiteo la transaccion

        fragmentTransaction.commit();

    }
}
