package com.example.digitalhouse.floatbuttonbase;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by andres on 04/10/16.
 */
public class SantaFragment extends Fragment {

    private ActivityListener activityListener;

    private TextInputLayout textInputLayoutMensaje;
    private TextInputEditText textInputEditTextMensaje;
    private TextInputLayout textInputLayoutRegalos;
    private TextInputEditText textInputEditTextRegalos;
    private FloatingActionButton floatingActionButtonSend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.santa_fragment, container, false);

        //Le paso la vista que infle anteriormente

        encontrarVistas(view);

        validarCampos();

        onClickListenerFloatingButton();

        return view;

    }

    //En este metodo se debe pasar por paramentro una vista para que se puedan encontrar lo
    //componentes ya que es un fragment

    private void encontrarVistas(View view){
        textInputLayoutMensaje = view.findViewById(R.id.SantaFragment_TextInputLayout_Mensaje);
        textInputEditTextMensaje = view.findViewById(R.id.SantaFragment_TextInputEditText_Mensaje);
        textInputLayoutRegalos = view.findViewById(R.id.SantaFragment_TextInputLayout_Regalo);
        textInputEditTextRegalos = view.findViewById(R.id.SantaFragment_TextInputEditText_Regalo);
        floatingActionButtonSend = view.findViewById(R.id.SantaFragment_FloatingActionButton_Send);
    }

    private void validarCampos(){
        textInputEditTextMensaje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //El onTextChange se corre cada ves que hay alguna modificacion en el EditText
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                //El charSequence es la cadena de texto que hay en el edit text
                if(charSequence.length() < 1){
                    //Le seteo el mensaje de error al TextInputLayout
                    textInputLayoutMensaje.setError("Porfavor completar el campo mensaje");
                }else{
                    //Le borro el mensaje de error cunado el contenido esta bien
                    textInputLayoutMensaje.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activityListener = (ActivityListener) context;
    }

    private void onClickListenerFloatingButton(){
        floatingActionButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //isEmpty funciona para saber si un editText esta vacio o no (si esta vacio devuelve
                //un true y si esta con contenido devuelve un false)
                //El ! al principio indica que a lo que devuelva lo va dar vuelta , por ejemplo si
                //el editText esta vacio va a devolver TRUE pero yo no quiero que entre entonce lo
                //cambio al opuesto y si esta con algo de contenido va a devolver FALSE pero con el
                //sigono de exclamacion adelante va a terminar siendo un TRUE y va a entrar a la
                //condicion
                //La condicion esta la hago para evitar errores de tipo NullPointerException(Estos
                //errores indican que un valor esta en null)

                if (!textInputEditTextMensaje.getText().toString().isEmpty() && !textInputEditTextRegalos.getText().toString().isEmpty()){
                    String stringMensaje = textInputEditTextMensaje.getText().toString();
                    String stringRegalos = textInputEditTextRegalos.getText().toString();
                    //le paso a quien sea que este escuchando el contenido del mesaje y del regalo en el onclick
                    activityListener.notificarActivity(textInputEditTextMensaje.getText().toString(),textInputEditTextRegalos.getText().toString());
                }else if (!textInputEditTextMensaje.getText().toString().isEmpty()){
                    String stringMensaje = textInputEditTextMensaje.getText().toString();
                    String stringRegalos = "No pidio ningun regalo";
                    //le paso a quien sea que este escuchando el contenido del mesaje y del regalo en el onclick
                    activityListener.notificarActivity(stringMensaje,stringRegalos);
                }else{
                    Toast.makeText(getContext(), "No puso ningun mensaje", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //creo la interface que indica el protocolo de comunicacion que va a tener con esta activity
    public interface ActivityListener{
        public void notificarActivity(String mensaje, String regalo);
    }
}
