package test.onetomany;

import infra.DAO;
import model.onetomany.ItemOrder;
import model.onetomany.Order;

public class GetOrders {
	
	public static void main(String[] args) {
		
		DAO<Order> daoOrder = new DAO<Order>(Order.class);
		
		Order order = daoOrder.selectByID(1L);
		
		for(ItemOrder item: order.getItens()) {
			System.out.println(item.getQuantity());
		}
		
		daoOrder.close();
		
	}

}
