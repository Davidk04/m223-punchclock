package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Benutzer;


@ApplicationScoped
public class BenutzerService {

    @Inject
    EntityManager entityManager;

    public List<Benutzer> getAll() {
        var anfrage = entityManager.createQuery("FROM Benutzer", Benutzer.class);
        return anfrage.getResultList();
    }

    @Transactional
    public Benutzer makeBenutzer(Benutzer benutzer) {
        entityManager.persist(benutzer);
        return benutzer;
    }

    public Benutzer GetBenutzerById(Long id){
        var suche = entityManager.find(Benutzer.class, id);
        return suche;
    }

    @Transactional
    public void deleteBenutzerById(Long id) {
        var suche = entityManager.find(Benutzer.class, id);
        entityManager.remove(suche);
    }

    @Transactional
    public Benutzer updateBenutzerById(Long id, Benutzer benutzer) {
        return entityManager.merge(benutzer);
    }
}
