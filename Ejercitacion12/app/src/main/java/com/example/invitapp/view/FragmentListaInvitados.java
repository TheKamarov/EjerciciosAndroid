package com.example.invitapp.view;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.invitapp.R;
import com.example.invitapp.controller.InvitadoController;
import com.example.invitapp.model.Invitado;
import com.example.invitapp.utils.ResultListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaInvitados extends Fragment implements InvitadoAdapter.ListenerDelAdapter {

    private RecyclerView recyclerView;

    private ListenerDelInvitado listenerDelInvitado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_invitados, container, false);

        //Encontrar las vistas
        recyclerView = view.findViewById(R.id.FragmentListaInvitados_RecyclerView_ListaDeInvitados);

        //encontrar El adapter
        final InvitadoAdapter invitadoAdapter = new InvitadoAdapter(this);
        InvitadoController invitadoController = new InvitadoController();
        invitadoController.traerInvitado(new ResultListener<List<Invitado>>() {
            @Override
            public void finish(List<Invitado> result) {
                invitadoAdapter.setInvitadoList(result);
            }
        });

        //setearle el LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        //setearle el adapter
        recyclerView.setAdapter(invitadoAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listenerDelInvitado = (ListenerDelInvitado) context;
    }

    public void informarInvitadoSeleccionado(Invitado invitado){
        listenerDelInvitado.recibirInvitado(invitado);
    }

    public interface ListenerDelInvitado{
        public void recibirInvitado(Invitado invitado);
    }

}
