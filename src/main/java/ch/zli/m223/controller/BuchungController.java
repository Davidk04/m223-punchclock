package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Buchung;
import ch.zli.m223.service.BuchungService;

@Path("/buchung")
@Tag(name = "Buchungen", description = "Handhabung von Buchungen")
public class BuchungController {

    @Inject
    BuchungService buchungService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)   
    public List<Buchung> getBuchungen() {
        return buchungService.getAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Buchung create(Buchung buchung) {
        return buchungService.makeBuchung(buchung);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Buchung getOneBuchung(@PathParam("id") Long id) {
            return buchungService.GetBuchungById(id);
    }
    
    //Works but doesnt return any message
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        buchungService.deleteBuchungById(id);
    }
}
