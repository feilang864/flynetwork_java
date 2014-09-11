/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game_engine.data.log.controllor;

import com.game_engine.data.log.CreatLog;
import com.game_engine.data.log.controllor.exceptions.NonexistentEntityException;
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
public class CreatLogJpaController implements Serializable {

    public CreatLogJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CreatLog creatLog) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(creatLog);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CreatLog creatLog) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            creatLog = em.merge(creatLog);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = creatLog.getId();
                if (findCreatLog(id) == null) {
                    throw new NonexistentEntityException("The creatLog with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CreatLog creatLog;
            try {
                creatLog = em.getReference(CreatLog.class, id);
                creatLog.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The creatLog with id " + id + " no longer exists.", enfe);
            }
            em.remove(creatLog);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CreatLog> findCreatLogEntities() {
        return findCreatLogEntities(true, -1, -1);
    }

    public List<CreatLog> findCreatLogEntities(int maxResults, int firstResult) {
        return findCreatLogEntities(false, maxResults, firstResult);
    }

    private List<CreatLog> findCreatLogEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CreatLog.class));
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

    public CreatLog findCreatLog(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CreatLog.class, id);
        } finally {
            em.close();
        }
    }

    public int getCreatLogCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CreatLog> rt = cq.from(CreatLog.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
