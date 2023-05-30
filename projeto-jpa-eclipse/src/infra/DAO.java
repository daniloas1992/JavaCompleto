package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	Class<E> myClass;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("projeto-jpa-eclipse");
		} catch (Exception e) {
			// gerar log com a biblioteca "log4j"
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> myClass) {
		this.myClass = myClass;
		em = emf.createEntityManager();
	}
	
	public DAO<E> openTransaction() {
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> closeTransaction() {
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> insert(E entity) {
		em.persist(entity);
		return this;
	}
	
	public DAO<E> insertWithTransacty(E entity) {
		return this.openTransaction().insert(entity).closeTransaction();
	}
	
	public E selectByID(Object id) {
		return em.find(myClass, id);
	}
	
	public List<E> selectAll() {
		return this.selectAll(10, 0);
	}
	
	public List<E> selectAll(final int limit, final int offset) {
		if(myClass == null) {
			throw new UnsupportedOperationException("Null class!");
		}
		
		String jpql = "SELECT E FROM " + myClass.getName() + " E";
		TypedQuery<E> query = em.createQuery(jpql, myClass);
		query.setMaxResults(limit);
		query.setFirstResult(offset);
		
		return query.getResultList();
	}
	
	public List<E> selectByQuery(String queryName, Object... params) {
		TypedQuery<E> query = em.createNamedQuery(queryName, myClass);
		
		for(int i=0; i < params.length; i+=2) {
			query.setParameter(params[i].toString(), params[i+1]);
		}
		
		return query.getResultList();
	}
	
	public E selectByNativeQuery(String queryName, Object... params) {
		List<E> list = selectByQuery(queryName, params);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public void close() {
		em.close();
	}
}
