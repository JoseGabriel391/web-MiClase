
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
import logica.AlumnoProfesor;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.RollbackFailureException;


public class AlumnoProfesorJpaController implements Serializable {

    public AlumnoProfesorJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public AlumnoProfesorJpaController() {
        emf = Persistence.createEntityManagerFactory("MiClasePU");
    }

    public void create(AlumnoProfesor alumnoProfesor) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
             em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumnoProfesor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AlumnoProfesor alumnoProfesor) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            alumnoProfesor = em.merge(alumnoProfesor);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = alumnoProfesor.getAlumnoProfesorId();
                if (findAlumnoProfesor(id) == null) {
                    throw new NonexistentEntityException("The alumnoProfesor with id " + id + " no longer exists.");
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
            utx.begin();
            em = getEntityManager();
            AlumnoProfesor alumnoProfesor;
            try {
                alumnoProfesor = em.getReference(AlumnoProfesor.class, id);
                alumnoProfesor.getAlumnoProfesorId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alumnoProfesor with id " + id + " no longer exists.", enfe);
            }
            em.remove(alumnoProfesor);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AlumnoProfesor> findAlumnoProfesorEntities() {
        return findAlumnoProfesorEntities(true, -1, -1);
    }

    public List<AlumnoProfesor> findAlumnoProfesorEntities(int maxResults, int firstResult) {
        return findAlumnoProfesorEntities(false, maxResults, firstResult);
    }

    private List<AlumnoProfesor> findAlumnoProfesorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AlumnoProfesor.class));
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

    public AlumnoProfesor findAlumnoProfesor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AlumnoProfesor.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlumnoProfesorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AlumnoProfesor> rt = cq.from(AlumnoProfesor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
