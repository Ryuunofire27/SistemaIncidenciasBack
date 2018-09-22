package com.charlie.sistemaincidencias.resource;

import com.charlie.sistemaincidencias.entity.Oficina;
import com.charlie.sistemaincidencias.entity.Select;
import com.charlie.sistemaincidencias.service.OficinaService;
import com.charlie.sistemaincidencias.serviceImplement.OficinaImplement;
import com.charlie.sistemaincidencias.util.Status;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Produces("Application/json")
@Path("oficina")
public class OficinaResource {
    
    private OficinaService oficinaService = new OficinaImplement();
    
    @GET
    @Path("/all")
    public Response getOficinas(){
        List<Oficina> oficinas;
        Status status = new Status();
        List<Select> objects = new ArrayList<>();
        oficinas = oficinaService.getOficinas(status);
        
        for(Oficina ofi : oficinas){
            Select select = new Select();
            select.setId(ofi.getIdOficina());
            select.setOpcion(ofi.getDescripcion());
            objects.add(select);
        }
        
        return Response.ok(objects)
                .header("Access-Control-Allow-Origin", "http://localhost:3000")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers","origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
        
    }
}
