package ch.zli.m223.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.MAX;

import ch.zli.m223.model.Benutzer;

import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthService {
    @Inject
    EntityManager entityManager;

    @Inject
    BenutzerService benutzerService;

    @Inject
    JsonWebToken jwt;

    @Transactional
    public String findUser(String email, String password) {
        List<Benutzer> benutzers = benutzerService.getAll();
        String jwt = "";
        for (Benutzer benutzer : benutzers) {
            if (benutzer.getEmail().equals(email) && benutzer.getPasswort().equals(password)) {
                String token = Jwt.issuer("https://example.com/issuer")
                        .upn(benutzer.getEmail())
                        .groups(benutzer.getRolle().getTitel())
                        .expiresIn(Integer.MAX_VALUE)
                        .sign();
                return jwt = token;
            }
        }
        throw new IllegalArgumentException("Your Email oder Passwort sind falsch");
    }
}
