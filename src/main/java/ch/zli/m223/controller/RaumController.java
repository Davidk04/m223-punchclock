package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
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
    RaumService service;

    @GET
    @RolesAllowed({"admin", "mitglied"})
    @Produces(MediaType.APPLICATION_JSON)   
    public List<Raum> getRaum() {
        return service.getAll();
    }

    @POST
    @RolesAllowed({"admin"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Raum create(Raum raum) {
        return service.makeRaum(raum);
    }

    @GET
    @RolesAllowed({"admin", "mitglied"})
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Raum getOneRaum(@PathParam("id") Long id) {
            return service.GetRaumById(id);
    }
    
    //Works but doesnt return any message
    @DELETE
    @RolesAllowed({"admin"})
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.deleteRaumById(id);
    }

    @PUT
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Raum update(@PathParam("id") Long id, Raum raum){
            return service.updateRaumById(id, raum);
    }
}