package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import logica.Nota;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.RollbackFailureException;

public class NotasJpaController implements Serializable {

    public NotasJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public NotasJpaController() {
        emf = Persistence.createEntityManagerFactory("MiClasePU");
    }

    public void create(Nota notas) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(notas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nota notas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            notas = em.merge(notas);
            em.getTransaction().commit();
        } catch (Exception ex) {
           
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = notas.getNotaId();
                if (findNotas(id) == null) {
                    throw new NonexistentEntityException("The notas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nota notas;
            try {
                notas = em.getReference(Nota.class, id);
                notas.getNotaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The notas with id " + id + " no longer exists.", enfe);
            }
            em.remove(notas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nota> findNotasEntities() {
        return findNotasEntities(true, -1, -1);
    }

    public List<Nota> findNotasEntities(int maxResults, int firstResult) {
        return findNotasEntities(false, maxResults, firstResult);
    }

    private List<Nota> findNotasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nota.class));
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

    public Nota findNotas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nota.class, id);
        } finally {
            em.close();
        }
    }

    public int getNotasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nota> rt = cq.from(Nota.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
