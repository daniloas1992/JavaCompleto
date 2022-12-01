package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
  public static void main(String[] args)  throws SQLException{

    Connection connection = ConnectionFactory.getConnection();

    System.out.println("Conexão efetuada com sucesso!");
    connection.close();

  }
}
