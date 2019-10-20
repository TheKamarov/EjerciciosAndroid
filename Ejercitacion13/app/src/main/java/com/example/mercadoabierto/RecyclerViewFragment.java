package com.example.mercadoabierto;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerView;
    List<Producto> listaDeProductos = new ArrayList<>();

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        encontrarVistas(view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

        ProductoAdapter productoAdapter = new ProductoAdapter(generarListaDeProductos());

        recyclerView.setAdapter(productoAdapter);

        return view;

    }

    private void encontrarVistas(View view){
        this.recyclerView = view.findViewById(R.id.RecyclerViewFragment_RecyclerView_ListaDeProductos);
    }

    private List<Producto> generarListaDeProductos(){

        listaDeProductos.add(new Producto(R.drawable.asus,"Computadora Asus", "$8000"));
        listaDeProductos.add(new Producto(R.drawable.karambit, "Cuchillo Karambit", "$3500"));
        listaDeProductos.add(new Producto(R.drawable.i8, "BMW I8", "$450000"));
        listaDeProductos.add(new Producto(R.drawable.asus,"Computadora Asus", "$8000"));
        listaDeProductos.add(new Producto(R.drawable.karambit, "Cuchillo Karambit", "$3500"));
        listaDeProductos.add(new Producto(R.drawable.i8, "BMW I8", "$450000"));
        listaDeProductos.add(new Producto(R.drawable.asus,"Computadora Asus", "$8000"));
        listaDeProductos.add(new Producto(R.drawable.karambit, "Cuchillo Karambit", "$3500"));
        listaDeProductos.add(new Producto(R.drawable.i8, "BMW I8", "$450000"));
        listaDeProductos.add(new Producto(R.drawable.asus,"Computadora Asus", "$8000"));
        listaDeProductos.add(new Producto(R.drawable.karambit, "Cuchillo Karambit", "$3500"));
        listaDeProductos.add(new Producto(R.drawable.i8, "BMW I8", "$450000"));
        listaDeProductos.add(new Producto(R.drawable.asus,"Computadora Asus", "$8000"));
        listaDeProductos.add(new Producto(R.drawable.karambit, "Cuchillo Karambit", "$3500"));
        listaDeProductos.add(new Producto(R.drawable.i8, "BMW I8", "$450000"));
        listaDeProductos.add(new Producto(R.drawable.asus,"Computadora Asus", "$8000"));
        listaDeProductos.add(new Producto(R.drawable.karambit, "Cuchillo Karambit", "$3500"));
        listaDeProductos.add(new Producto(R.drawable.i8, "BMW I8", "$450000"));
        listaDeProductos.add(new Producto(R.drawable.asus,"Computadora Asus", "$8000"));
        listaDeProductos.add(new Producto(R.drawable.karambit, "Cuchillo Karambit", "$3500"));
        listaDeProductos.add(new Producto(R.drawable.i8, "BMW I8", "$450000"));
        listaDeProductos.add(new Producto(R.drawable.asus,"Computadora Asus", "$8000"));
        listaDeProductos.add(new Producto(R.drawable.karambit, "Cuchillo Karambit", "$3500"));
        listaDeProductos.add(new Producto(R.drawable.i8, "BMW I8", "$450000"));

        return listaDeProductos;
    }

}
