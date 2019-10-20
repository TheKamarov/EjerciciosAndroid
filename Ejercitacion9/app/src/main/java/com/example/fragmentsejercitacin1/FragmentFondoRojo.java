package com.example.fragmentsejercitacin1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentFondoRojo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inflo la vista que va a mostrar el fragment
        View view = inflater.inflate(R.layout.fragment_fondo_rojo, container, false);

        //Aca podria trabajar con la vista , por ejemplo con botones , etc...

        //Hago un return de la vista

        return view;
    }
}
