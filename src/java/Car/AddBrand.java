package Car;

import Database.DatabaseConnection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named("addBrandBean")
@ViewScoped
public class AddBrand implements Serializable {

    DatabaseConnection conn = new DatabaseConnection();

    private String brandName;
    private String country;
    private String logo;

    public void addBrand() {

        if(brandName.isEmpty() || country.isEmpty() || logo.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Please fill in the whole form."));
            return;
        }

        if(!checkBrand(brandName)) {
            return;
        }

        try {
            PreparedStatement addCar = conn.doConnect().prepareStatement("insert into cars.brands (brandname, country, logo) values (?,?,?)");
            addCar.setString(1, brandName);
            addCar.setString(2, country);
            addCar.setString(3, logo);
            addCar.execute();

            brandName = ""; country = ""; logo = "";
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Check if brand already exists
     */
    public Boolean checkBrand(String brandName) {
        try {
            PreparedStatement checkBrand = conn.doConnect().prepareStatement("select * from cars.brands where brandname = ?");
            checkBrand.setString(1, brandName);
            checkBrand.execute();

            ResultSet result = checkBrand.getResultSet();
            if(result.next()) {
                return true;
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        }

        FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("That brand already exists in our system."));
        return false;
    }

    /**
     * Getters and setters
     */
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }

}
