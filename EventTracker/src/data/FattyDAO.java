package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class FattyDAO {
	@PersistenceContext
	EntityManager em;

	public Fatitie getByID(int id){
		return em.find(Fatitie.class, id);
	}
	
	public Fatitie getFat() {
		return em.find(Fatitie.class, 3);
	}

	public List<Fatitie> getAllFatites() {
		CriteriaQuery<Fatitie> cq = em.getCriteriaBuilder().createQuery(Fatitie.class);
		cq.select(cq.from(Fatitie.class));
		List<Fatitie> allFatites = em.createQuery(cq).getResultList();
		return allFatites;
	}
	
	public Boolean newFatitie (Fatitie f) {
        em.persist(f);
        return true;
    }

    public Boolean deleteFat(int id) {
        Fatitie e = em.find(Fatitie.class, id);
        em.remove(e);
        if (em.contains(e)) {
            return false;
        } else {
            return true;
        }
    }

}


