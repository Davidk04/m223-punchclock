package ch.zli.m223.controller;

import javax.annotation.security.PermitAll;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Benutzer;
import ch.zli.m223.service.AuthService;
import ch.zli.m223.service.BenutzerService;

@Path("/auth")
@Tag(name = "Auth", description = "Handhabung von of Auth")
public class AuthController {
    @Inject
    BenutzerService benutzerService;

    @Inject
    AuthService auth;

    @Inject
    JsonWebToken jwt;

    @POST
    @Path("/register")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Benutzer create(Benutzer benutzer) {
        return benutzerService.makeBenutzer(benutzer);
    }

    @POST
    @Path("/login")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String login(@QueryParam("email")String email, @QueryParam("passwort") String passwort) {
        return auth.findUser(email, passwort);
    }
}
