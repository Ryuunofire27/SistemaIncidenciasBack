package com.charlie.sistemaincidencias.serviceImplement;

import com.charlie.sistemaincidencias.entity.Problema;
import com.charlie.sistemaincidencias.factory.ConnectionFactory;
import com.charlie.sistemaincidencias.service.ProblemasService;
import com.charlie.sistemaincidencias.util.PageStatus;
import com.charlie.sistemaincidencias.util.Status;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;

public class ProblemasImplement implements ProblemasService{

    @Override
    public List<Problema> obtenerProblemas(Status status) {
        List<Problema> problemas = null;
        SqlSession sesion = null;
        
        try {
            sesion = ConnectionFactory.obtenerSesion();
            if(sesion!=null){
                problemas = sesion.selectList("Problema.obtenerProblemas");
                PageStatus.ok(status);
            }
        } catch (IOException ex) {
            Logger.getLogger(IncidenciaImplement.class.getName()).log(Level.SEVERE, null, ex);
            PageStatus.error(status);
        }finally{
            ConnectionFactory.cerrarSesion(sesion);
        }
        
        
        return problemas;
    }
    
}
