package test.basic;

import infra.DAO;
import model.basic.Product;

public class NewProduct {
	
	public static void main(String[] args) {
		
		DAO<Product> dao = new DAO<>(Product.class);
		
		Product product = new Product("notebook", 2877.45);
		
		dao.insertWithTransacty(product).close();
		//dao.openTransaction().insert(product).closeTransaction().close();
		
		System.out.println("ID: " + product.getId());
		
	}

}
