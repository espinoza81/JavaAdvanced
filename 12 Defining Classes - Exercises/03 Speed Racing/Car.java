package SpeedRacing;

public class Car {
    private final String model;
    private double fuelAmount;
    private final double fuelForKilometer;
    private int distance =0;

    public Car(String model, double fuelAmount, double fuelForKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelForKilometer = fuelForKilometer;
    }

    public void move(Car temp, double amountOfKm){
        if(temp.fuelForKilometer*amountOfKm <= temp.fuelAmount) {
            temp.setFuelAmount(amountOfKm);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distance);
    }

    public void setFuelAmount(double amountOfKm) {
        this.fuelAmount -= fuelForKilometer*amountOfKm;
        this.distance += amountOfKm;
    }
}
