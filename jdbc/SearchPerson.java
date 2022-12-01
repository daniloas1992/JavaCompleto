package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchPerson {

  public static void main(String[] args) throws SQLException {

    Connection connection = ConnectionFactory.getConnection();

    final String sql = "SELECT * FROM people";

    Statement stmt = connection.createStatement();
    ResultSet resultSelect = stmt.executeQuery(sql);

    List<Person> people = new ArrayList<>();

    while(resultSelect.next()) {
      int id = resultSelect.getInt("id");
      String name = resultSelect.getString("name");
      people.add(new Person(id, name));
    }

    for(Person p: people) {
      System.out.println(p.getId() + " ---> " + p.getName());
    }

    stmt.close();
    connection.close();;
  }

}
