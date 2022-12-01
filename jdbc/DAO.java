package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

  private Connection connection;

  private Connection getConnection() {
    try {
      if(connection != null && !connection.isClosed()) {
        return connection;
      }
    } catch (SQLException e) {

    }

    connection = ConnectionFactory.getConnection();
    return connection;
  }

  public int insert(final String sql, final Object... atributes) {
    try {
      PreparedStatement stmt = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

      addAtributes(stmt, atributes);

      if(stmt.executeUpdate() > 0) {
        ResultSet result = stmt.getGeneratedKeys();

        if(result.next()) {
          return result.getInt(1);
        }
      }

      return -1;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  private void addAtributes(PreparedStatement stmt, Object[] atributes) throws SQLException {

    int index = 1;

    for(Object atribute: atributes) {
      if(atribute instanceof String) {
        stmt.setString(index, (String) atribute);
      } else if (atribute instanceof Integer) {
        stmt.setInt(index, (Integer) atribute);
      }
      index++;
    }
  }

  public void close() {
    try {
      getConnection().close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      connection = null;
    }
  }
  
}
