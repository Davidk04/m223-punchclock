package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Raum;

@ApplicationScoped
public class RaumService {

    @Inject
    EntityManager entityManager;

    public List<Raum> getAll() {
        var anfrage = entityManager.createQuery("FROM Raum", Raum.class);
        return anfrage.getResultList();
    }

    @Transactional
    public Raum makeRaum(Raum raum) {
        entityManager.persist(raum);
        return raum;
    }

    public Raum GetRaumById(Long id){
        var suche = entityManager.find(Raum.class, id);
        return suche;
    }

    @Transactional
    public void deleteRaumById(Long id) {
        var suche = entityManager.find(Raum.class, id);
        entityManager.remove(suche);
    }

    @Transactional
    public Raum updateRaumById(Long id, Raum raum) {
        return entityManager.merge(raum);
    }
}