package Car;

public class BrandConstructor {
    
    private String brandName;
    private String country;
    private String logo;
    private Integer id;
    private Integer stock;
    
    public BrandConstructor(Integer id, String brandName, String country, String logo, Integer stock) {
        this.id = id;
        this.brandName = brandName;
        this.country = country;
        this.logo = logo;
        this.stock = stock;
    }
    
    /**
     * Getters and setters
     */
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
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
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
}
