package Car;

public class CarConstructor {

    private String brandName;
    private String modelName;
    private Double price;
    private Double cc;
    private String photo;
    private Integer seats;
    private Integer id;

    public CarConstructor(Integer id, String brandName, String modelName, String photo, Double price, Double cc, Integer seats) {
        this.id = id;
        this.brandName = brandName;
        this.modelName = modelName;
        this.photo = photo;
        this.price = price;
        this.cc = cc;
        this.seats = seats;
    }

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
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public Integer getSeats() {
        return seats;
    }
    public void setSeats(Integer seats) {
        this.seats = seats;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

}
