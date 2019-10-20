package com.example.invitapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.invitapp.model.Invitado;
import com.example.invitapp.R;

import java.util.ArrayList;
import java.util.List;

public class InvitadoAdapter extends RecyclerView.Adapter<InvitadoAdapter.InvitadoViewHolder> {

    private List<Invitado> listaDeInvitados;
    private ListenerDelAdapter listenerDelAdapter;

    public InvitadoAdapter(List<Invitado> listaDeInvitados) {
        this.listaDeInvitados = listaDeInvitados;
    }

    public InvitadoAdapter(ListenerDelAdapter listenerDelAdapter){
        listaDeInvitados = new ArrayList<>();
        this.listenerDelAdapter = listenerDelAdapter;
    }

    @NonNull
    @Override
    public InvitadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.celda_invitado, parent,false);
        return new InvitadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InvitadoViewHolder holder, int position) {
        Invitado invitadoMostrado = listaDeInvitados.get(position);

        holder.bindInvitado(invitadoMostrado);
    }


    @Override
    public int getItemCount() {
        return this.listaDeInvitados.size();
    }

    public void setInvitadoList(List<Invitado> invitadoList){
        this.listaDeInvitados = invitadoList;
        notifyDataSetChanged();
    }

    public class InvitadoViewHolder extends RecyclerView.ViewHolder{

        //Los atributos son componentes visules de la celda
        private TextView textViewNombre;

        //en el constructor del view holder encontrabamos los componentes visuales
        //el item view era la vista inflada de la celda
        public InvitadoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.CeldaRecycler_TextView_Nombre);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Invitado invitadoSeleccionado = listaDeInvitados.get(getAdapterPosition());
                    listenerDelAdapter.informarInvitadoSeleccionado(invitadoSeleccionado);
                }
            });
        }

        //la celda va saber como cargar la informacion en sus componentes
        public void bindInvitado(Invitado invitadoDeLaCelda){
            invitadoDeLaCelda.setStringNombre(invitadoDeLaCelda.getStringNombre());
        }
    }



    public interface ListenerDelAdapter{
        public void informarInvitadoSeleccionado(Invitado invitado);
    }
}
