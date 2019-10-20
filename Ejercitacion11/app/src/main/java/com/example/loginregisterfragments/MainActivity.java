package com.example.loginregisterfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FragmentFormulario.NotificadorActivities {

    private FrameLayout frameLayoutContenedorDeFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pegarFragment(new FragmentFormulario());


    }

    private void pegarFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.MainActivity_FrameLayout_ContenedorDeFragments, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void recibirMensaje(String username) {

        // creo el intent a la nueva actividad (el pasaje)
        Intent intent = new Intent(this,WelcomeActivity.class);

        //Creo el Bundle (La valija)
        Bundle bundle = new Bundle();

        //Le guardo los valores al Bundle (Cargo la valija)
        bundle.putString(WelcomeActivity.CLAVE_USERNAME, username);

        //Le agregamos el Bundle al Intent (es muy impotante poner el putExtras con la S al final)
        intent.putExtras(bundle);

        //Arrancamos la nueva activity
        startActivity(intent);
    }
}
