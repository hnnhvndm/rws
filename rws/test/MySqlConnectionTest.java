import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MySqlConnectionTest {

    String url = "jdbc:mysql://localhost:3306/4pp";
    String username = "rws";
    String password = "RWSassignment";

    @org.junit.jupiter.api.Test
    void getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        boolean available = connection.isValid(10);
        assertTrue(available);
    }
}
