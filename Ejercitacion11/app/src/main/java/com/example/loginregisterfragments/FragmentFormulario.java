package com.example.loginregisterfragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFormulario extends Fragment {

    private NotificadorActivities notificadorActivities;

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    public FragmentFormulario() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_formulario, container, false);

        encontrarVistas(view);

        funcionalidadButton();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.notificadorActivities = (NotificadorActivities) context;
    }

    private void encontrarVistas(View view){
        editTextUsername = view.findViewById(R.id.FragmentFormulario_EditText_Username);
        editTextPassword = view.findViewById(R.id.FragmentFormulario_EditText_Password);
        buttonLogin = view.findViewById(R.id.FragmentFormulario_Button_Login);
    }

    public interface NotificadorActivities{
        public void recibirMensaje(String username);
    }

    private void funcionalidadButton(){

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editTextUsername.getText().toString().isEmpty() && !editTextPassword.getText().toString().isEmpty()){
                    String stringUsername = editTextUsername.getText().toString();
                    notificadorActivities.recibirMensaje(stringUsername);
                }else{
                    Toast.makeText(getContext(), "Faltan completar campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
