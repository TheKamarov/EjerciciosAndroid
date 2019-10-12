package com.example.fragmentsejercitacion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botonCambiarRojo;
    private Button botonCambiarVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonCambiarRojo = findViewById(R.id.activityMain_button_pegarRojo);
        botonCambiarVerde = findViewById(R.id.activityMain_button_pegarVerde);

        pegarFragment(new FragmentVerde());

        botonCambiarVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pegarFragment(new FragmentVerde());
            }
        });

        botonCambiarRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentRojo fragmentRojo = new FragmentRojo();
                pegarFragment(fragmentRojo);
            }
        });
    }

    private void pegarFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.contenedorDeFragments,fragment,null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
