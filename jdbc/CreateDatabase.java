package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
  
  public static void main(String[] args)  throws SQLException{
    
    Connection connection = ConnectionFactory.getConnection();

    Statement stmt = connection.createStatement();
    stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");

    System.out.println("Database create successful!");
    connection.close();

  }

}
