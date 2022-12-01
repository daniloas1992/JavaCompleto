package jdbc;

public class DAOTest {
  public static void main(String[] args) {
    
    DAO dao = new DAO();

    final String sql = "INSERT INTO people (name) VALUES (?)";

    System.out.println("Inserted person with id: " + dao.insert(sql,"John"));
    System.out.println("Inserted person with id: " + dao.insert(sql,"Pedro"));
    System.out.println("Inserted person with id: " + dao.insert(sql,"Lucas"));

    dao.close();
  }
}
