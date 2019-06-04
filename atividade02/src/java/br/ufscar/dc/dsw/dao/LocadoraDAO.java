package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Locadora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class LocadoraDAO extends GenericDAO<Locadora> {

    @Override
    public Locadora get(Long id) {
        EntityManager em = this.getEntityManager();
        Locadora locadora = em.find(Locadora.class, id);
        em.close();
        return locadora;
    }

    @Override
    public void save(Locadora locadora) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(locadora);
        tx.commit();
        em.close();
    }

    @Override
    public List<Locadora> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select l from Locadora l", Locadora.class);
        List<Locadora> locadora = q.getResultList();
        em.close();
        return locadora;
    }

    @Override
    public void delete(Locadora locadora) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        locadora = em.getReference(Locadora.class, locadora.getId());
        tx.begin();
        em.remove(locadora);
        tx.commit();
    }

    @Override
    public void update(Locadora locadora) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(locadora);
        tx.commit();
        em.close();
    }

    public List<Locadora> getAllCidade(String cidade) {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select l from Locadora l where l.cidade = '" + cidade + "'", Locadora.class);
        List<Locadora> locadora = q.getResultList();
        em.close();
        return locadora;
    }

    public List<String> getCidades() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select l.cidade from Locadora l", Locadora.class);
        List<String> cidade = q.getResultList();
        em.close();
        return cidade;
    }

    public String getcnpj(Long id) {
        EntityManager em = this.getEntityManager();
        TypedQuery<Locadora> q = em.createQuery("SELECT l FROM Locadora l, Usuario u WHERE l.id = '" + id + "' and l.id = u.id", Locadora.class);
        Locadora l = q.getSingleResult();
        return l.getCnpj();
    }
}
