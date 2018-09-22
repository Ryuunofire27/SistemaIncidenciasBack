package com.charlie.sistemaincidencias.service;

import com.charlie.sistemaincidencias.entity.Incidencia;
import com.charlie.sistemaincidencias.util.Status;
import java.util.List;
import java.util.Map;

public interface IncidenciasService {
    
    List<Incidencia> getIncidencias(Status status);
    
    Incidencia getIncidencia(Status status, int id);
    
    void setIncidencia(Status status, Map cambios);
    
    void newIncidencia(Status status, Map nuevo);
    
    void deleteIncidencia(Status status, int id);
    
}
