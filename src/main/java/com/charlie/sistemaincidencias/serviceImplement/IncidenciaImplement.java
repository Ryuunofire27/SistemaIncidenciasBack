package com.charlie.sistemaincidencias.serviceImplement;

import com.charlie.sistemaincidencias.entity.Incidencia;
import com.charlie.sistemaincidencias.factory.ConnectionFactory;
import com.charlie.sistemaincidencias.service.IncidenciasService;
import com.charlie.sistemaincidencias.util.PageStatus;
import com.charlie.sistemaincidencias.util.Status;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;

public class IncidenciaImplement implements IncidenciasService{

    @Override
    public List<Incidencia> getIncidencias(Status status) {
        List<Incidencia> incidencias = null;
        SqlSession sesion = null;
        
        try {
            sesion = ConnectionFactory.obtenerSesion();
            if(sesion!=null){
                incidencias = sesion.selectList("Incidencia.obtenerIncidencias");
                PageStatus.ok(status);
            }
        } catch (IOException ex) {
            Logger.getLogger(IncidenciaImplement.class.getName()).log(Level.SEVERE, null, ex);
            PageStatus.error(status);
        }finally{
            ConnectionFactory.cerrarSesion(sesion);
        }
        
        
        return incidencias;
        
    }

    @Override
    public Incidencia getIncidencia(Status status, int id) {
        Incidencia incidencia = null;
        SqlSession sesion = null;
        
        try {
            sesion = ConnectionFactory.obtenerSesion();
            if(sesion!=null){
                incidencia = sesion.selectOne("Incidencia.obtenerIncidencia", id);
                PageStatus.ok(status);
            }
        } catch (IOException ex) {
            Logger.getLogger(IncidenciaImplement.class.getName()).log(Level.SEVERE, null, ex);
            PageStatus.error(status);
        }finally{
            ConnectionFactory.cerrarSesion(sesion);
        }
        
        return incidencia;
    }

    @Override
    public void setIncidencia(Status status, Map cambios) {
        SqlSession sesion = null;
        
        try {
            sesion = ConnectionFactory.obtenerSesion();
            if(sesion!=null){
                sesion.update("Incidencia.modificarIncidencia", cambios);
                PageStatus.ok(status);
            }
        } catch (IOException ex) {
            Logger.getLogger(IncidenciaImplement.class.getName()).log(Level.SEVERE, null, ex);
            PageStatus.error(status);
        }finally{
            ConnectionFactory.cerrarSesion(sesion);
        }
    }

    @Override
    public void newIncidencia(Status status, Map nuevo) {
        SqlSession sesion = null;
        
        try {
            sesion = ConnectionFactory.obtenerSesion();
            if(sesion!=null){
                sesion.insert("Incidencia.registrarIncidencia", nuevo);
                PageStatus.ok(status);
            }
        } catch (IOException ex) {
            Logger.getLogger(IncidenciaImplement.class.getName()).log(Level.SEVERE, null, ex);
            PageStatus.error(status);
        }finally{
            ConnectionFactory.cerrarSesion(sesion);
        }
    }

    @Override
    public void deleteIncidencia(Status status, int id) {
        SqlSession sesion = null;
        
        try {
            sesion = ConnectionFactory.obtenerSesion();
            if(sesion!=null){
                sesion.insert("Incidencia.eliminarIncidencia", id);
                PageStatus.ok(status);
            }
        } catch (IOException ex) {
            Logger.getLogger(IncidenciaImplement.class.getName()).log(Level.SEVERE, null, ex);
            PageStatus.error(status);
        }finally{
            ConnectionFactory.cerrarSesion(sesion);
        }
    }
    
}
