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

@Named("addCarBean")
@ViewScoped
public class AddCar implements Serializable {

    DatabaseConnection conn = new DatabaseConnection();

    private String brandName;
    private String modelName;
    private Double price;
    private Double cc;
    private String photo;
    private Integer seats;

    public void addCar() {
        if(brandName.isEmpty() || modelName.isEmpty() || price == null || cc == null || seats == null || photo.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Please fill in all the inputs."));
            return;
        }

        /*
        Verify brand exists
         */
        if(!verifyBrand(brandName)) {
            return;
        }

        try {
            PreparedStatement addCar = conn.doConnect().prepareStatement("insert into cars.models (brand, modelname, photo, price, cc, seats) values (?,?,?,?,?,?)");
            addCar.setString(1, brandName);
            addCar.setString(2, modelName);
            addCar.setString(3, photo);
            addCar.setDouble(4, price);
            addCar.setDouble(5, cc);
            addCar.setInt(6, seats);

            addCar.execute();

            brandName = ""; modelName = ""; photo = ""; price = null; cc = null; seats = null; //reset all variables to empty the form
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        FacesContext.getCurrentInstance().addMessage("Success", new FacesMessage("Car added with success."));
    }

    /**
     * Function to check if the brand exists in the system.
     */
    public Boolean verifyBrand(String brandName) {
        try {
            PreparedStatement checkBrand = conn.doConnect().prepareStatement("select * from cars.brands where brandname = ?");
            checkBrand.setString(1, brandName);
            checkBrand.execute();
            ResultSet result = checkBrand.getResultSet();
            if(result.next()) {
                return true;
            }
        } catch(SQLException | NullPointerException e) {
            System.out.println(e.toString());
        }

        FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("We do not have that brand in our system."));
        return false;
    }

    /**
     * Getters and Setters
     */
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getCc() {
        return cc;
    }
    public void setCc(Double cc) {
        this.cc = cc;
    }
    public Integer getSeats() {
        return seats;
    }
    public void setSeats(Integer seats) {
        this.seats = seats;
    }

}
