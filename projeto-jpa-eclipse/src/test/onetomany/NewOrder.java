package test.onetomany;

import infra.DAO;
import model.basic.Product;
import model.onetomany.ItemOrder;
import model.onetomany.Order;

public class NewOrder {
	
	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Order order = new Order();
		Product product = new Product("Computador", 3897.45);		
		ItemOrder item = new ItemOrder(order, product, 10); 
		
		dao.openTransaction()
		   .insert(product)
		   .insert(order)
		   .insert(item)
		   .closeTransaction()
		   .close();
		
	}

}
