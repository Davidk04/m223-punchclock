package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.zli.m223.model.Buchung;


@ApplicationScoped
public class BuchungService {
    @Inject
    EntityManager entityManager;

    public List<Buchung> getAll() {
        var query = entityManager.createQuery("FROM Buchung", Buchung.class);
        return query.getResultList();
    }
}
