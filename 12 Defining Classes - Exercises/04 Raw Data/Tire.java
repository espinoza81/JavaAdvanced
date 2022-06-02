package RawData;

public class Tire {
    private double tireOnePressure;
    private double tireTwoPressure;
    private double tireThreePressure;
    private double tireFourPressure;
    private int tireOneAge;
    private int tireTwoAge;
    private int tireThreeAge;
    private int tireFourAge;

    public Tire(double tireOnePressure, int tireOneAge, double tireTwoPressure, int tireTwoAge, double tireThreePressure, int tireThreeAge, double tireFourPressure,   int tireFourAge) {
        this.tireOnePressure = tireOnePressure;
        this.tireTwoPressure = tireTwoPressure;
        this.tireThreePressure = tireThreePressure;
        this.tireFourPressure = tireFourPressure;
        this.tireOneAge = tireOneAge;
        this.tireTwoAge = tireTwoAge;
        this.tireThreeAge = tireThreeAge;
        this.tireFourAge = tireFourAge;
    }

    public double getTireOnePressure() {
        return tireOnePressure;
    }

    public void setTireOnePressure(double tireOnePressure) {
        this.tireOnePressure = tireOnePressure;
    }

    public double getTireTwoPressure() {
        return tireTwoPressure;
    }

    public void setTireTwoPressure(double tireTwoPressure) {
        this.tireTwoPressure = tireTwoPressure;
    }

    public double getTireThreePressure() {
        return tireThreePressure;
    }

    public void setTireThreePressure(double tireThreePressure) {
        this.tireThreePressure = tireThreePressure;
    }

    public double getTireFourPressure() {
        return tireFourPressure;
    }

    public void setTireFourPressure(double tireFourPressure) {
        this.tireFourPressure = tireFourPressure;
    }

    public int getTireOneAge() {
        return tireOneAge;
    }

    public void setTireOneAge(int tireOneAge) {
        this.tireOneAge = tireOneAge;
    }

    public int getTireTwoAge() {
        return tireTwoAge;
    }

    public void setTireTwoAge(int tireTwoAge) {
        this.tireTwoAge = tireTwoAge;
    }

    public int getTireThreeAge() {
        return tireThreeAge;
    }

    public void setTireThreeAge(int tireThreeAge) {
        this.tireThreeAge = tireThreeAge;
    }

    public int getTireFourAge() {
        return tireFourAge;
    }

    public void setTireFourAge(int tireFourAge) {
        this.tireFourAge = tireFourAge;
    }
}
