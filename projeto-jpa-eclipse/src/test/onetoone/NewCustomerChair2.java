package test.onetoone;

import infra.DAO;
import model.onetoone.Chair;
import model.onetoone.Customer;

public class NewCustomerChair2 {
	
	public static void main(String[] args) {
		
		Chair chair = new Chair("4D");
		Customer customer = new Customer("Rodrigo", chair);
		
		DAO<Customer> dao = new DAO<>(Customer.class);
		
		dao.insertWithTransacty(customer);
		
	}

}
