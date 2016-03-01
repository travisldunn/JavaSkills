package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class TestFat {
	
	public static void main(String[] args) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("fatPU");
	        EntityManager em = emf.createEntityManager();
	        
	             CriteriaQuery<Fatitie> cq = em.getCriteriaBuilder().createQuery(Fatitie.class);
	                cq.select(cq.from(Fatitie.class));
	               List<Fatitie> fats = em.createQuery(cq).getResultList();
	               for(Fatitie fat : fats) {
	            	   System.out.println(fat.getCurrentFat());
	                   System.out.println(fat.getGoalFat());
	                   System.out.println(fat.getFatFood());
	               }
	        }
	}


