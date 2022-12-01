package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTablePeople {

  public static void main(String[] args) throws SQLException{
    
    Scanner in = new Scanner(System.in);

    System.out.println("Insert name: ");
    String name = in.nextLine();

    final String sql = "INSERT INTO people (name) VALUES (?)";
    
    Connection connection = ConnectionFactory.getConnection();
    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setString(1, name);
    stmt.execute();

    System.out.println("Inserted successful!");
    in.close();

  }
  
}
