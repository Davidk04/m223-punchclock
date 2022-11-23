package ch.zli.m223.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
}
