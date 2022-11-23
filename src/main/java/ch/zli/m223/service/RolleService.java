package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Rolle;


@ApplicationScoped
public class RolleService {

    @Inject
    EntityManager entityManager;

    public List<Rolle> getAll() {
        var anfrage = entityManager.createQuery("FROM Rolle", Rolle.class);
        return anfrage.getResultList();
    }

    @Transactional
    public Rolle makeRolle(Rolle rolle) {
        entityManager.persist(rolle);
        return rolle;
    }

    public Rolle GetRolleById(Long id){
        var suche = entityManager.find(Rolle.class, id);
        return suche;
    }

    @Transactional
    public void deleteRolleById(Long id) {
        var suche = entityManager.find(Rolle.class, id);
        entityManager.remove(suche);
    }

    @Transactional
    public Rolle updateRolleById(Long id, Rolle rolle) {
        return entityManager.merge(rolle);
    }
}
    