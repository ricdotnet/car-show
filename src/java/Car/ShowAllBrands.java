package Car;

import Database.DatabaseConnection;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("showAllBrandsBean")
@ViewScoped
public class ShowAllBrands implements Serializable {
    
    DatabaseConnection conn = new DatabaseConnection();
    
    private List<BrandConstructor> allBrands;
    
    public void fetchAllBrands() {
        allBrands = new ArrayList<>();
        try {
            PreparedStatement getBrands = conn.doConnect().prepareStatement("select * from cars.brands");
            getBrands.execute();
            
            ResultSet result = getBrands.getResultSet();
            
            while(result.next()) {
                allBrands.add(new BrandConstructor(
                        result.getInt("id"),
                        result.getString("brandname"),
                        result.getString("country"),
                        result.getString("logo")
                ));
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public List<BrandConstructor> printBrands() {
        fetchAllBrands();
        return allBrands;
    }
    
    /**
     * Delete Brand Logic
     */
    public void removeBrand(Integer id) {
        try {
            PreparedStatement deleteBrand = conn.doConnect().prepareStatement("delete from cars.brands where id = ?");
            deleteBrand.setInt(1, id);
            deleteBrand.execute();
            
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("allBrandsTable");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
}
