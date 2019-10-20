package com.example.digitalhouse.floatbuttonbase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReceptorFragment extends Fragment {

    //Le tengo que poner clave para que la activity se pueda comunicar con el fragment
    public static final String CLAVE_MENSAJE = "claveMensaje";
    public static final String CLAVE_REGALO = "claveRegalo";

    private TextView textViewMensaje;
    private TextView textViewRegalos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receptor, container, false);

        encuentroLosComponentes(view);

        obtengoLaInformacionQueMePasoLaActivity();

        return view;
    }

    private void encuentroLosComponentes(View view){
        textViewMensaje = view.findViewById(R.id.ReceptorFragment_TextView_Mensaje);
        textViewRegalos = view.findViewById(R.id.ReceptorFragment_TextView_Regalos);
    }

    private void obtengoLaInformacionQueMePasoLaActivity(){

        //agarro el bundle que me vino de la activity
        Bundle bundle = getArguments();

        //agarro el mensaje y el regalo del bundle
        String stringMensaje = bundle.getString(CLAVE_MENSAJE);
        String stringRegalos = bundle.getString(CLAVE_REGALO);

        //Le Seteo los datos que agarre del Bundle al TextView
        textViewMensaje.setText(stringMensaje);
        textViewRegalos.setText(stringRegalos);
    }
}
