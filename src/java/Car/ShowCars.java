/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import Database.DatabaseConnection;

@Named("showCarsBean")
@ViewScoped
public class ShowCars implements Serializable {
    
    DatabaseConnection conn = new DatabaseConnection();

    private String brandName;
    private String modelName;
    private Double price;
    private Double cc;
    private String photo;

    private List<CarConstructor> last9; //featured in the home page

    public void getLast9() {
        last9 = new ArrayList<>();
        try {
            PreparedStatement getCars = conn.doConnect().prepareStatement("select * from cars.models");
            getCars.execute();
            ResultSet result = getCars.getResultSet();
            int i = 0; //this is to stop at 9 loops
            while (result.next()) {
                if(i < 9) {
                    last9.add(new CarConstructor(
                            result.getString("brand"),
                            result.getString("modelname"),
                            result.getString("photo"),
                            result.getDouble("price"),
                            result.getDouble("cc"),
                            result.getInt("seats")
                    ));

                    i++;
                } else {
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public List<CarConstructor> printLast9() {
        getLast9();
        return last9;
    }
    
}
