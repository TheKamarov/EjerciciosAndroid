package com.example.mercadoabierto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter {

    private List<Producto> listaDeProductos;

    public ProductoAdapter(List<Producto> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.celda_producto, parent,false);

        ProductoViewHolder productoViewHolder = new ProductoViewHolder(view);

        return productoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Producto unProductoDeLaLista = this.listaDeProductos.get(position);
        ProductoViewHolder productoViewHolder = (ProductoViewHolder) holder;
        productoViewHolder.bindProducto(unProductoDeLaLista);
    }

    @Override
    public int getItemCount() {
        return this.listaDeProductos.size();
    }

    private class ProductoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewImagenDelProducto;
        private TextView textViewNombreDelProducto;
        private TextView textViewPrecioDelProducto;
        private Producto productoDeLaCelda;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewImagenDelProducto = itemView.findViewById(R.id.CeldaProducto_ImageView_FotoDelProducto);
            textViewNombreDelProducto = itemView.findViewById(R.id.CeldaProducto_TextView_NombreDelProducto);
            textViewPrecioDelProducto = itemView.findViewById(R.id.CeldaProducto_TextView_PrecioDelProducto);
        }

        public void bindProducto(Producto productoDeLaCelda){
            this.productoDeLaCelda = productoDeLaCelda;
            this.imageViewImagenDelProducto.setImageResource(this.productoDeLaCelda.getIntegerImagenDelProducto());
            this.textViewNombreDelProducto.setText(this.productoDeLaCelda.getStringNombreDelProducto());
            this.textViewPrecioDelProducto.setText(this.productoDeLaCelda.getStringPrecioDelProducto());
        }
    }
}
