package com.charlie.sistemaincidencias.factory;

import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public final class ConnectionFactory {
    
    private ConnectionFactory(){}
    
    public static SqlSession obtenerSesion() throws IOException{
        
        Reader reader = null;
        SqlSession sesion = null;
        try {
            reader = Resources.getResourceAsReader("mybatis_config.xml");
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            sesion = sqlMapper.openSession(true);
            return sesion;
        } catch (IOException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sesion;
    }

    public static void cerrarSesion(SqlSession sesion) {
        
        if (sesion != null) {
            sesion.rollback();
            sesion.close();
        }
        
    }
    
}
