package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class UpdateUser1 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-jpa-eclipse");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		User user = em.find(User.class, 3L);
		user.setName("Name 3 updated");
		user.setEmail("email3@update.com");
		em.merge(user);
		em.getTransaction().commit();
		
		emf.close();
		em.close();
		
	}
}
