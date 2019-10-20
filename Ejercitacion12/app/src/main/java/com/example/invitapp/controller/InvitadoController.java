package com.example.invitapp.controller;

import com.example.invitapp.model.Invitado;
import com.example.invitapp.model.InvitadoDao;
import com.example.invitapp.utils.ResultListener;

import java.util.List;

public class InvitadoController {

    //por ahora el controler es un simple pasamanos que le pise al dao y se lo pasa a la vista
    public void traerInvitado(final ResultListener<List<Invitado>> listenerDeLaVista){
        InvitadoDao invitadoDao = new InvitadoDao();

        invitadoDao.traerInvitados(new ResultListener<List<Invitado>>() {
            @Override
            public void finish(List<Invitado> result) {
                listenerDeLaVista.finish(result);
            }
        });
    }
}
