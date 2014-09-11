/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game_engine.data.log.controllor;

import com.game_engine.data.log.Testlog;
import com.game_engine.data.log.controllor.exceptions.NonexistentEntityException;
import com.game_engine.data.log.controllor.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author fly_troy
 */
public class TestlogJpaController implements Serializable {

    public TestlogJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Testlog testlog) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(testlog);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTestlog(testlog.getInt1()) != null) {
                throw new PreexistingEntityException("Testlog " + testlog + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Testlog testlog) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            testlog = em.merge(testlog);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = testlog.getInt1();
                if (findTestlog(id) == null) {
                    throw new NonexistentEntityException("The testlog with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Testlog testlog;
            try {
                testlog = em.getReference(Testlog.class, id);
                testlog.getInt1();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The testlog with id " + id + " no longer exists.", enfe);
            }
            em.remove(testlog);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Testlog> findTestlogEntities() {
        return findTestlogEntities(true, -1, -1);
    }

    public List<Testlog> findTestlogEntities(int maxResults, int firstResult) {
        return findTestlogEntities(false, maxResults, firstResult);
    }

    private List<Testlog> findTestlogEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Testlog.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Testlog findTestlog(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Testlog.class, id);
        } finally {
            em.close();
        }
    }

    public int getTestlogCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Testlog> rt = cq.from(Testlog.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
