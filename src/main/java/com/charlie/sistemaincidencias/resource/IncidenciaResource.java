package com.charlie.sistemaincidencias.resource;

import com.charlie.sistemaincidencias.entity.Incidencia;
import com.charlie.sistemaincidencias.service.IncidenciasService;
import com.charlie.sistemaincidencias.serviceImplement.IncidenciaImplement;
import com.charlie.sistemaincidencias.util.Status;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Produces("Application/json")
@Path("incidencia")
public class IncidenciaResource {

    private IncidenciasService incidenciasService= new IncidenciaImplement();
    
    
    @GET
    @Path("/all")
    public Response getIncidencias(){
        
        List<Incidencia> incidencias;
        Status status = new Status();
        
        incidencias = incidenciasService.getIncidencias(status);
        
        return Response.ok(incidencias)
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }
    
    @GET
    @Path("/{id}")
    public Response getIncidencia(@PathParam("id") int id){
        Incidencia incidencia;
        Status status = new Status();
        incidencia = incidenciasService.getIncidencia(status, id);
        
        return Response.ok(incidencia)
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
        
    }
    
    @PUT
    @Consumes("Application/json")
    @Path("/new")
    public Response createIncidencia(Incidencia incidencia){
        Map<String,Object> crearIncidencia = new HashMap<>();
        Status status = new Status();
        crearIncidencia.put("problema", incidencia.getProblema());
        crearIncidencia.put("oficina", incidencia.getOficina());
        crearIncidencia.put("tecnico", incidencia.getTecnico());
        crearIncidencia.put("fechaRevision", incidencia.getFechaRevision());
        crearIncidencia.put("fechaTermino", incidencia.getFechaTermino());
        crearIncidencia.put("solucion", incidencia.getSolucion());
        crearIncidencia.put("usuario", incidencia.getUsuario());
        
        incidenciasService.newIncidencia(status, crearIncidencia);
        System.out.println(crearIncidencia.containsKey("problema"));
        System.out.println(crearIncidencia.containsKey("oficina"));
        System.out.println(crearIncidencia.containsKey("tecnico"));
        System.out.println(crearIncidencia.containsKey("fechaRevision"));
        System.out.println(crearIncidencia.containsKey("fechaTermino"));
        System.out.println(crearIncidencia.containsKey("solucion"));
        System.out.println(crearIncidencia.containsKey("usuario"));
        
        return Response.status(Response.Status.OK).entity(status)
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
        
        
    }
    
    @POST
    @Consumes("Application/json")
    @Path("/set")
    public Response modificarIncidencia(Incidencia incidencia){
        Map<String, Object> crearIncidencia = new HashMap<>();
        Status status = new Status();
        
        crearIncidencia.put("id", incidencia.getIdIncidencia());
        crearIncidencia.put("problema", incidencia.getProblema());
        crearIncidencia.put("oficina", incidencia.getOficina());
        crearIncidencia.put("tecnico", incidencia.getTecnico());
        crearIncidencia.put("fechaRevision", incidencia.getFechaRevision());
        crearIncidencia.put("fechaTermino", incidencia.getFechaTermino());
        crearIncidencia.put("solucion", incidencia.getSolucion());
        crearIncidencia.put("usuario", incidencia.getUsuario());
        
        incidenciasService.setIncidencia(status, crearIncidencia);
        
        status.setMensaje("Modificado con exito");
        
        return Response.status(Response.Status.OK).entity(status)
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteIncidencia(@PathParam("id") int id){
        Status status = new Status();
        incidenciasService.deleteIncidencia(status, id);
        
        status.setMensaje("Eliminado con exito");
        
        return Response.status(Response.Status.CREATED).entity(status)
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
        
    }
}
