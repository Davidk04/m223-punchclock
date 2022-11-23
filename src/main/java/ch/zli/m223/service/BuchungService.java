package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Buchung;


@ApplicationScoped
public class BuchungService {
    @Inject
    EntityManager entityManager;

    public List<Buchung> getAll() {
        var anfrage = entityManager.createQuery("FROM Buchung", Buchung.class);
        return anfrage.getResultList();
    }

    @Transactional
    public Buchung makeBuchung(Buchung buchung) {
        entityManager.persist(buchung);
        return buchung;
    }

    public Buchung GetBuchungById(Long id){
        var suche = entityManager.find(Buchung.class, id);
        return suche;
    }

    @Transactional
    public void deleteBuchungById(Long id) {
        var suche = entityManager.find(Buchung.class, id);
        entityManager.remove(suche);
    }
}
