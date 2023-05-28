package test.onetoone;

import infra.DAO;
import model.onetoone.Chair;
import model.onetoone.Customer;

public class GetChairCustomer {
	
	public static void main(String[] args) {
		
		DAO<Customer> daoCustomer = new DAO<>(Customer.class);
		
		Customer customer = daoCustomer.selectByID(1L);
		System.out.println(customer.getChair().getName());
		
		daoCustomer.close();
		
		
		DAO<Chair> daoChair = new DAO<>(Chair.class);
		Chair chair = daoChair.selectByID(3L);
		
		System.out.println(chair.getCustomer().getName());
		
		daoChair.close();
	}

}
