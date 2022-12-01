package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletePerson {
  
  public static void main(String[] args)  throws SQLException {

    Connection connection = ConnectionFactory.getConnection();

    Scanner in = new Scanner(System.in);

    System.out.println("Input id for delete: ");
    int id = in.nextInt();

    final String sql = "DELETE FROM people WHERE id = ?";

    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setInt(1, id);

    if(stmt.executeUpdate() > 0) {
      System.out.println("\nDelete successful!");
    } else {
      System.out.println("\nID not found!");
    }

    in.close();
    connection.close();
    
  }

}
