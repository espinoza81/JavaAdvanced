package CarSalesman;

public class Car {
    private String model;
    public Engine engine;
    private int weight = 0;
    private String color = "n/a";

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    @Override
    public String toString() {
        return  String.format(model + ":%n" +
                engine.getModel() + ":%n" +
                "Power: " + engine.getPower() +
                "%nDisplacement: " + (engine.getDisplacement()==0 ? "n/a" : engine.getDisplacement()) +
                "%nEfficiency: " + engine.getEfficiency() +
                "%nWeight: " + (weight==0 ? "n/a" : weight) +
                "%nColor: " + color);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
