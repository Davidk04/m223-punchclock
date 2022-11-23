package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Raum;
import ch.zli.m223.service.RaumService;

@Path("/raum")
@Tag(name = "Raum", description = "Handhabung von Räumen")
public class RaumController {
    @Inject
    RaumService raumService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)   
    public List<Raum> getRaum() {
        return raumService.getAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Raum create(Raum raum) {
        return raumService.makeRaum(raum);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Raum getOneRaum(@PathParam("id") Long id) {
            return raumService.GetRaumById(id);
    }
    
    //Works but doesnt return any message
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        raumService.deleteRaumById(id);
    }

    @PUT
    @Path("/{id}")
    public Raum update(@PathParam("id") Long id, Raum raum){
            return raumService.updateRaumById(id, raum);
    }
}