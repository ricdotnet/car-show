package Car;

import Database.DatabaseConnection;
import Car.CarConstructor;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Named("showAllCarsBean")
@ViewScoped
public class ShowAllCars implements Serializable {

    DatabaseConnection conn = new DatabaseConnection();

    List<CarConstructor> allCars;

    public void fetchCars() {
        allCars = new ArrayList<>();
        try {
            PreparedStatement getCars = conn.doConnect().prepareStatement("select * from cars.models order by id desc");
            getCars.execute();

            ResultSet result = getCars.getResultSet();
            while (result.next()) {
                allCars.add(new CarConstructor(
                        result.getInt("id"),
                        result.getString("brand"),
                        result.getString("modelname"),
                        result.getString("photo"),
                        result.getDouble("price"),
                        result.getDouble("cc"),
                        result.getInt("seats")
                ));
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
    }

    public List<CarConstructor> printAllCars() {
        fetchCars();
        return allCars;
    }

    /**
     * Remove car from the database
     */
    public void removeCar(Integer id) {
        try {
            PreparedStatement deleteCar = conn.doConnect().prepareStatement("delete from cars.models where id = ?");
            deleteCar.setInt(1, id);
            deleteCar.execute();

            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("allCarsTable");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Edit a car logic
     */
    private static CarConstructor selectedCar;
    public CarConstructor getSelectedCar() {
        return selectedCar;
    }
    public void setSelectedCar(CarConstructor selectedCar) {
        ShowAllCars.selectedCar = selectedCar;
    }
    public void saveCar() {
        try {
            PreparedStatement saveCar = conn.doConnect().prepareStatement("update cars.models set brand = ?, modelname = ?, price = ?, cc = ?, seats = ?, photo = ? where id = ?");
            saveCar.setString(1, selectedCar.getBrandName());
            saveCar.setString(2, selectedCar.getModelName());
            saveCar.setDouble(3, selectedCar.getPrice());
            saveCar.setDouble(4, selectedCar.getCc());
            saveCar.setInt(5, selectedCar.getSeats());
            saveCar.setString(6, selectedCar.getPhoto());
            saveCar.setInt(7, selectedCar.getId());
            saveCar.execute();
            FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
        } catch (SQLException | IOException e) {
            System.out.println(e.toString());
        }
    }

}
