package CarInfo;

public class Car {
    private final String brand;
    private String model = "unknown";
    private int horsePower = -1;

    public Car(String brand) {
        this.brand = brand;
    }

    public Car(String brand, String model, int horsePower) {
        this(brand);
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
    
    public int getHorsePower() {
        return horsePower;
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }
}
