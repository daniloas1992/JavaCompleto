package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.basic.User;

public class NewUser {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-jpa-eclipse");
		EntityManager em = emf.createEntityManager();
		
		User newUser = new User("Nome Teste 6", "teste6@email.com");
		em.getTransaction().begin();
		em.persist(newUser);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
