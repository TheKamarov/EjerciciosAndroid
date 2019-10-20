package com.example.mercadoabierto;

public class Producto {

    private Integer integerImagenDelProducto;
    private String stringNombreDelProducto;
    private String stringPrecioDelProducto;

    public Producto(Integer integerImagenDelProducto, String stringNombreDelProducto, String stringPrecioDelProducto) {
        this.integerImagenDelProducto = integerImagenDelProducto;
        this.stringNombreDelProducto = stringNombreDelProducto;
        this.stringPrecioDelProducto = stringPrecioDelProducto;
    }

    public Integer getIntegerImagenDelProducto() {
        return integerImagenDelProducto;
    }

    public void setIntegerImagenDelProducto(Integer integerImagenDelProducto) {
        this.integerImagenDelProducto = integerImagenDelProducto;
    }

    public String getStringNombreDelProducto() {
        return stringNombreDelProducto;
    }

    public void setStringNombreDelProducto(String stringNombreDelProducto) {
        this.stringNombreDelProducto = stringNombreDelProducto;
    }

    public String getStringPrecioDelProducto() {
        return stringPrecioDelProducto;
    }

    public void setStringPrecioDelProducto(String stringPrecioDelProducto) {
        this.stringPrecioDelProducto = stringPrecioDelProducto;
    }
}
