package com.example.digitalhouse.floatbuttonbase;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SantaFragment.ActivityListener{

    private FragmentManager miFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miFragmentManager = getSupportFragmentManager();

        SantaFragment santaFragment = new SantaFragment();

        pegarFragment(santaFragment);

    }

    private void pegarFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                //Replace indica va apegarce arriba de los otros fragments o activities
                .replace(R.id.contenedorDeFragments,fragment)
                //addToBackStack quiere decir que al apretar la flecha retroceder va atener en
                //cuanta que se puso un fragment y antes de salir de la app va a eliminar la accion
                //de poner el fragment
                .addToBackStack(null)
                .commit();
    }

    //creo el metodo que le avisa a la activity que el fragment se esta comunicando
    //basicamente le elijo el comportamiento que quiero que tenga cuando el fragment se comunica
    //entonces dos activities pueden estar usando el mismo fragment pero actuar diferente cuando se comunica
    @Override
    public void notificarActivity(String mensaje, String regalo){
        //Creo el Fragment
        ReceptorFragment receptorFragment = new ReceptorFragment();
        //Le creo el bundle (La valija)
        Bundle bundle = new Bundle();
        //Le pongo al Bundle la informacion que me paso el Fragment
        bundle.putString(ReceptorFragment.CLAVE_MENSAJE, mensaje);
        bundle.putString(ReceptorFragment.CLAVE_REGALO, regalo);
        receptorFragment.setArguments(bundle);
        //Lo pego
        pegarFragment(receptorFragment);
    }
}
