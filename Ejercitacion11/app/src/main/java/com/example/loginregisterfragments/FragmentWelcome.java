package com.example.loginregisterfragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.loginregisterfragments.WelcomeActivity.CLAVE_USERNAME;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWelcome extends Fragment {

    private MuestraDeLogin mustraDelLogin;
    private TextView textViewWelcome;

    public FragmentWelcome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        encuentroLasVistas(view);

        //Obtengo la informacion del bundle
        Bundle bundle = getArguments();

        //pongo la informacion que quiero dentro de una variable
        String stringUsername = bundle.getString(CLAVE_USERNAME);

        textViewWelcome.setText("¡Welcome "+stringUsername+"!");

        return view;
    }


    private void encuentroLasVistas(View view){
        textViewWelcome = view.findViewById(R.id.FragmentWelcome_TextView_Welcome);
    }

    public interface MuestraDeLogin{
        public void mostrarLogin(String usuario);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mustraDelLogin = (MuestraDeLogin) context;
    }
}
