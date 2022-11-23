package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Rang;

@ApplicationScoped
public class RangService {

    @Inject
    EntityManager entityManager;

    public List<Rang> getAll() {
        var anfrage = entityManager.createQuery("FROM Rang", Rang.class);
        return anfrage.getResultList();
    }

    @Transactional
    public Rang makeRang(Rang rang) {
        entityManager.persist(rang);
        return rang;
    }

    public Rang GetRangById(Long id){
        var suche = entityManager.find(Rang.class, id);
        return suche;
    }

    @Transactional
    public void deleteRangById(Long id) {
        var suche = entityManager.find(Rang.class, id);
        entityManager.remove(suche);
    }

    @Transactional
    public Rang updateRangById(Long id, Rang rang) {
        return entityManager.merge(rang);
    }
    
}
