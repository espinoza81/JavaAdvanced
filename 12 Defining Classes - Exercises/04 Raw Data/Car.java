package RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double tireOnePressure, int tireOneAge, double tireTwoPressure, int tireTwoAge, double tireThreePressure, int tireThreeAge, double tireFourPressure, int tireFourAge) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tire = new Tire(tireOnePressure, tireOneAge, tireTwoPressure, tireTwoAge, tireThreePressure, tireThreeAge, tireFourPressure, tireFourAge);
    }

    @Override
    public String toString() {
        return model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }
}
