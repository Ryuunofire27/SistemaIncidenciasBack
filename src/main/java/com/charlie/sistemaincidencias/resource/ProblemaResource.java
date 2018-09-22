package com.charlie.sistemaincidencias.resource;

import com.charlie.sistemaincidencias.entity.Problema;
import com.charlie.sistemaincidencias.entity.Select;
import com.charlie.sistemaincidencias.service.ProblemasService;
import com.charlie.sistemaincidencias.serviceImplement.ProblemasImplement;
import com.charlie.sistemaincidencias.util.Status;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;

@Produces("Application/json")
@Path("problema")
public class ProblemaResource implements Serializable{
    
    private ProblemasService problemasService = new ProblemasImplement();
    
    @GET
    @Path("/all")
    public Response getProblemas(){
        
        List<Problema> problemas;
        List<Select> selects = new ArrayList<>();
        Status status = new Status();
        
        problemas = problemasService.obtenerProblemas(status);
        
        for(Problema prob : problemas){
            Select select = new Select();
            
            select.setId(prob.getId());
            select.setOpcion(prob.getTipo());
            selects.add(select);
        }
        
        return Response.ok(selects)
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }
    
}
