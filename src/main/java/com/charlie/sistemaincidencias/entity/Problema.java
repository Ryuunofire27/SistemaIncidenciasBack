package com.charlie.sistemaincidencias.entity;

import java.io.Serializable;

public class Problema implements Serializable{
    private int idProblema;
    private String tipo;

    public int getId() {
        return idProblema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.idProblema = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
  
}
