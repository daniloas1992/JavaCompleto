package test.basic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.basic.User;

public class GetUsers {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-jpa-eclipse");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT U FROM User U"; // "USER" É O NOME DO MODEL/CLASSE
		TypedQuery<User> query = em.createQuery(jpql, User.class); // Aplica Reflection para mapear os campos da classe para o banco
		query.setMaxResults(5);
		
		List<User> users = query.getResultList();
		
		/*List<User> users = em.createQuery("SELECT U FROM User U", User.class)
				              .setMaxResults(5)
				              .getResultList();*/
		
		for(User user: users) {
			System.out.println("ID: " + user.getId() + " E-mail: " + user.getEmail());
		}
		
		emf.close();
		em.close();
		
	}

}
