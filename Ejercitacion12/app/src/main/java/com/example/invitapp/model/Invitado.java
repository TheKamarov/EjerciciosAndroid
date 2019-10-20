package com.example.invitapp.model;

import java.io.Serializable;

public class Invitado implements Serializable {

    private String stringNombre;

    public Invitado(String stringNombre){
        this.stringNombre = stringNombre;
    }

    public String getStringNombre() {
        return stringNombre;
    }

    public void setStringNombre(String stringNombre) {
        this.stringNombre = stringNombre;
    }
}