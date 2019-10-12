package com.example.digitalhouse.floatbuttonbase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by andres on 04/10/16.
 */
public class SantaFragment extends Fragment {

    private TextView textViewMensaje;
    private TextView textViewRegalos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.santa_fragment, container, false);


        String mensaje = getArguments().getString("mesaje");
        String regalos = getArguments().getString("regalos");

        textViewMensaje = view.findViewById(R.id.santaFragment_textView_mensaje);
        textViewRegalos = view.findViewById(R.id.santaFragment_textView_regalos);

        textViewMensaje.setText(mensaje);
        textViewRegalos.setText(regalos);

        return view;

    }
}
