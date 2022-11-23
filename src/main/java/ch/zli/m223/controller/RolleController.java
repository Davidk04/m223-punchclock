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

import ch.zli.m223.model.Rolle;
import ch.zli.m223.service.RolleService;

@Path("/rolle")
@Tag(name = "Rolle", description = "Handhabung von Rollen")
public class RolleController {
    
    @Inject
    RolleService service;

    @GET
    @RolesAllowed({"admin"})
    @Produces(MediaType.APPLICATION_JSON)   
    public List<Rolle> getRolle() {
        return service.getAll();
    }

    @POST
    @RolesAllowed({"admin"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Rolle create(Rolle rolle) {
        return service.makeRolle(rolle);
    }

    @GET
    @RolesAllowed({"admin"})
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Rolle getOneRolle(@PathParam("id") Long id) {
            return service.GetRolleById(id);
    }
    
    //Works but doesnt return any message
    @DELETE
    @RolesAllowed({"admin"})
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.deleteRolleById(id);
    }

    @PUT
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Rolle update(@PathParam("id") Long id, Rolle rolle){
            return service.updateRolleById(id, rolle);
    }
}
