package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePerson {

  public static void main(String[] args)  throws SQLException {
    
    Connection connection = ConnectionFactory.getConnection();

    Scanner in = new Scanner (System.in);
    System.out.println("Input person code: ");
    final int id = in.nextInt();

    final String sql = "SELECT * FROM people WHERE id = ? ";
    
    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setInt(1, id);
    ResultSet resultSelect = stmt.executeQuery();

    if(resultSelect.next()) {
      
      Person p = new Person(resultSelect.getInt("id"), resultSelect.getString("name"));
      System.out.println("Name: " + p.getName());
      in.nextLine();

      System.out.println("\nNew name: ");
      String updateName = in.nextLine();

      final String sqlUpdate = "UPDATE people SET name = ? WHERE id = ?";

      stmt.close();
      stmt = connection.prepareStatement(sqlUpdate);
      stmt.setString(1, updateName);
      stmt.setInt(2, id);

      stmt.execute();

      System.out.println("Updated successful!");

    } else {
      System.out.println("\nPerson not found!");
    }

    in.close();
    stmt.close();
    connection.close();

  }
  
}
