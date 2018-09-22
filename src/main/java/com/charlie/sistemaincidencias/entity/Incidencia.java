package com.charlie.sistemaincidencias.entity;

import java.io.Serializable;

public class Incidencia implements Serializable{
    
    private int idIncidencia;
    private String oficina;
    private String problema;
    private String fechaRevision;
    private String usuario;
    private String tecnico;
    private String solucion;
    private String fechaTermino;

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int id) {
        this.idIncidencia = id;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(String fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }
    
    
    
}
