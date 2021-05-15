/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
