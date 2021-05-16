package Database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

//database connection class
public class DatabaseConnection {
    public Connection doConnect() {
        String url = "jdbc:derby://localhost/carshop";
        String user = "root";
        String password = "root";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
