package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchPersonByName {

  public static void main(String[] args) throws SQLException {

    Scanner in = new Scanner(System.in);
    System.out.println("Input name: ");
    String nameSearch = in.nextLine();

    Connection connection = ConnectionFactory.getConnection();

    final String sql = "SELECT * FROM people WHERE name LIKE ? ";

    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setString(1, "%" + nameSearch + "%");
    ResultSet resultSelect = stmt.executeQuery();

    List<Person> people = new ArrayList<>();

    while(resultSelect.next()) {
      int id = resultSelect.getInt("id");
      String name = resultSelect.getString("name");
      people.add(new Person(id, name));
    }

    for(Person p: people) {
      System.out.println(p.getId() + " ---> " + p.getName());
    }

    in.close();
    stmt.close();
    connection.close();;
  }

}
