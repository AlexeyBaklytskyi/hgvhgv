public class Phone {
    private String manufacturer;
    private double price;

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getManufacturerSPrice() {
               String b ="Price is "+String.valueOf(price)+" Manufacturer is "+manufacturer;
               return b;
    }
}
