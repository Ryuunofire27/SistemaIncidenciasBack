package com.charlie.sistemaincidencias.util;

import java.io.Serializable;

public class Status implements Serializable{
    
    private int estado;
    private String mensaje;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
