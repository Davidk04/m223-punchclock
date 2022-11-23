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

import ch.zli.m223.model.Benutzer;
import ch.zli.m223.service.BenutzerService;

@Path("/benutzer")
@Tag(name = "Benutzer", description = "Handhabung von Benutzer")
public class BenutzerController {

    @Inject
    BenutzerService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)   
    public List<Benutzer> getBenutzer() {
        return service.getAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Benutzer create(Benutzer benutzer) {
        return service.makeBenutzer(benutzer);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Benutzer getOneBenutzer(@PathParam("id") Long id) {
            return service.GetBenutzerById(id);
    }
    
    //Works but doesnt return any message
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.deleteBenutzerById(id);
    }

    @PUT
    @Path("/{id}")
    public Benutzer update(@PathParam("id") Long id, Benutzer benutzer){
            return service.updateBenutzerById(id, benutzer);
    }
}
