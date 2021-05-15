package Session;

import Database.DatabaseConnection;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named("sessionBean")
@SessionScoped
public class SessionStore implements Serializable {

    DatabaseConnection conn = new DatabaseConnection();

//    private static String username;
//    private static String email;
    private static Boolean isAdmin = false;







    /*
    Admin store and login logic
     */
    public static Boolean getAdminState() {
        return isAdmin;
    }
    public static void setAdminState(Boolean state) {
        isAdmin = state;
    }
    public void checkAdmin() throws IOException {
        if(!isAdmin) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("admin-login.xhtml");
        }
    }
    public void doLogin() {
        try {
            PreparedStatement login = conn.doConnect().prepareStatement("select * from cars.sellers where username = ? and password = ?");
            login.setString(1, username);
            login.setString(2, password);
            login.execute();

            ResultSet results = login.getResultSet();
            if(results.next()) {
                setAdminState(true);
                FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
            } else {
                FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("No user with those details."));
            }

        } catch (SQLException | IOException e) {
            System.out.println(e.toString());
        }
    }
    public void doLogout() throws IOException {
        setAdminState(false);
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    String username;
    String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
