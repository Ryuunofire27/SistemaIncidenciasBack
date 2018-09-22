package com.charlie.sistemaincidencias.service;

import com.charlie.sistemaincidencias.entity.Problema;
import com.charlie.sistemaincidencias.util.Status;
import java.util.List;

public interface ProblemasService {
    List<Problema> obtenerProblemas(Status status);
}
