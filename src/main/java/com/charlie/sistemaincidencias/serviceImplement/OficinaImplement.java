package com.charlie.sistemaincidencias.serviceImplement;

import com.charlie.sistemaincidencias.entity.Oficina;
import com.charlie.sistemaincidencias.factory.ConnectionFactory;
import com.charlie.sistemaincidencias.service.OficinaService;
import com.charlie.sistemaincidencias.util.PageStatus;
import com.charlie.sistemaincidencias.util.Status;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;

public class OficinaImplement implements OficinaService{

    @Override
    public List<Oficina> getOficinas(Status status) {
        List<Oficina> oficinas = null;
        SqlSession sesion = null;
        
        try {
            sesion = ConnectionFactory.obtenerSesion();
            if(sesion!=null){
                oficinas = sesion.selectList("Oficina.obtenerOficinas");
                PageStatus.ok(status);
            }
        } catch (IOException ex) {
            Logger.getLogger(IncidenciaImplement.class.getName()).log(Level.SEVERE, null, ex);
            PageStatus.error(status);
        }finally{
            ConnectionFactory.cerrarSesion(sesion);
        }
        
        
        return oficinas;
    }
    
}
