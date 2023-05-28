package test.onetoone;

import infra.DAO;
import model.onetoone.Chair;
import model.onetoone.Customer;

public class NewCustomerChair1 {
	
	public static void main(String[] args) {
		
		Chair chair = new Chair("24H");
		Customer customer = new Customer("João", chair);
		
		DAO<Object> dao = new DAO<>();
		
		dao.openTransaction()
		   .insert(chair)
		   .insert(customer)
		   .closeTransaction()
		   .close();		
	}

}
