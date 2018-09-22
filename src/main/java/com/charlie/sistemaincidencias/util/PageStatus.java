package com.charlie.sistemaincidencias.util;

import com.charlie.sistemaincidencias.util.Status;

public class PageStatus {
    
    private PageStatus(){}
    
    public static void ok(Status status){
        
        status.setEstado(200);
        status.setMensaje("Pagina encontrada");
    }
    
    public static void error(Status status){
        status.setEstado(500);
        status.setMensaje("Error");
    }
}
