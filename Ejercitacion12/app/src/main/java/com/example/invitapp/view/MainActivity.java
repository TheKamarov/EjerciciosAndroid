package com.example.invitapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.invitapp.R;
import com.example.invitapp.model.Invitado;

public class MainActivity extends AppCompatActivity implements FragmentListaInvitados.ListenerDelInvitado {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pegarFragment(new FragmentListaInvitados());
    }

    private void pegarFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.MainActivity_FrameLayout_ContenedorDeFragments, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void recibirInvitado(Invitado invitado) {

        //Aca voy a cargar el fragment con el detalle de la pelicula

        FragmentDetalleInvitado fragmentDetalleInvitado = new FragmentDetalleInvitado();

        Bundle bundle = new Bundle();

        bundle.putSerializable(FragmentDetalleInvitado.CLAVE_INVITADO,invitado);

        fragmentDetalleInvitado.setArguments(bundle);

        pegarFragment(fragmentDetalleInvitado);
    }
}
