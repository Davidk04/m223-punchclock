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

import ch.zli.m223.model.Rang;
import ch.zli.m223.service.RangService;

@Path("/rang")
@Tag(name = "Rang", description = "Handhabung von Rängen")
public class RangController {
    @Inject
    RangService service;

    @GET
    @RolesAllowed({"admin"})
    @Produces(MediaType.APPLICATION_JSON)   
    public List<Rang> getRang() {
        return service.getAll();
    }

    @POST
    @RolesAllowed({"admin"})
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Rang create(Rang rang) {
        return service.makeRang(rang);
    }

    @GET
    @RolesAllowed({"admin"})
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Rang getOneRang(@PathParam("id") Long id) {
            return service.GetRangById(id);
    }
    
    //Works but doesnt return any message
    @DELETE
    @RolesAllowed({"admin"})
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.deleteRangById(id);
    }

    @PUT
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Rang update(@PathParam("id") Long id, Rang rang){
            return service.updateRangById(id, rang);
    }

}