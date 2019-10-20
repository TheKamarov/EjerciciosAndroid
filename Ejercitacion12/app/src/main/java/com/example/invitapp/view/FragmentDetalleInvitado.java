package com.example.invitapp.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.invitapp.R;
import com.example.invitapp.model.Invitado;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleInvitado extends Fragment {


    public static final String CLAVE_INVITADO = "claveInvitado";

    private TextView textViewNombre;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_invitado, container, false);

        textViewNombre = view.findViewById(R.id.FragmentDetalleInvitado_TextView_Nombre);

        Bundle bundle = getArguments();

        Invitado invitadoSeleccionado = (Invitado) bundle.getSerializable(CLAVE_INVITADO);

        textViewNombre.setText(invitadoSeleccionado.getStringNombre());

        return view;
    }

}
