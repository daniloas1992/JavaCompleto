package test.inheritance;

import infra.DAO;
import model.inheritance.Student;
import model.inheritance.StudentSchorlarship;

public class NewStudent {
	
	public static void main(String[] args) {
		
		DAO<Student> dao = new DAO<>();
		
		Student student1 = new Student(123L, "Ricardo");
		StudentSchorlarship student2 = new StudentSchorlarship(124L, "João", 100.00);
		
		dao.insertWithTransacty(student1);
		dao.insertWithTransacty(student2);
		
		dao.close();
		
	}

}
