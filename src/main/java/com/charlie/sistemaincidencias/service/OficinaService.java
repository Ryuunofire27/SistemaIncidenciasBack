package com.charlie.sistemaincidencias.service;

import com.charlie.sistemaincidencias.entity.Oficina;
import com.charlie.sistemaincidencias.util.Status;
import java.util.List;

public interface OficinaService {
    
    List<Oficina> getOficinas(Status status);
    
}
