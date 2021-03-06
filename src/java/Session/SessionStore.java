package Session;

import Database.DatabaseConnection;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named("sessionBean")
@SessionScoped
public class SessionStore implements Serializable {

    DatabaseConnection conn = new DatabaseConnection();

    public static HttpSession session() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }
    public static Boolean isAdmin() {
        return (Boolean) session().getAttribute("isAdmin");
    }




    /**
     * Admin store and login logic.
     * This file stores an admin state when the user successful logs in.
     * It is a basic store. Because I use static variables then the state stays until the user leaves or logs out.
     */
    public void checkAdmin() {
        try {
            if (isAdmin() == null) {
                System.out.println("Unauthorized personnel tried to access the admin page.");
                FacesContext.getCurrentInstance().getExternalContext().redirect("admin-login.xhtml");
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    public void preventDoubleLogin() {
        try {
            if(isAdmin() != null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    public void doLogin() {

        if(username.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Please enter a username."));
            return;
        }
        if(password.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Please enter a password."));
            return;
        }

        try {
            PreparedStatement login = conn.doConnect().prepareStatement("select * from cars.sellers where username = ? and password = ?");
            login.setString(1, username);
            login.setString(2, password);
            login.execute();

            ResultSet results = login.getResultSet();
            if(results.next()) {
//                setAdminState(true);
                session().setAttribute("isAdmin", true);

                username = "";
                password = "";

                FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
            } else {
                FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("No user with those details."));
            }

        } catch (SQLException | IOException e) {
            System.out.println(e.toString());
        }
    }
    public void doLogout() throws IOException {
        session().invalidate();
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
