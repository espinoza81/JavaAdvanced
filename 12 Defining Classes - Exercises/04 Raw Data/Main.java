package RawData;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int line = Integer.parseInt(console.nextLine());
        Map<String, List<Car>> carsInCatalog = new HashMap<>();
        carsInCatalog.put("fragile", new ArrayList<>());
        carsInCatalog.put("flamable", new ArrayList<>());
        while (line-- > 0) {
            String[] token = console.nextLine().split("\\s+");
            String model = token[0];
            int engineSpeed = Integer.parseInt(token[1]);
            int enginePower = Integer.parseInt(token[2]);
            int cargoWeight = Integer.parseInt(token[3]);
            String cargoType = token[4];
            double tireOnePressure = Double.parseDouble(token[5]);
            int tireOneAge = Integer.parseInt(token[6]);
            double tireTwoPressure = Double.parseDouble(token[7]);
            int tireTwoAge  = Integer.parseInt(token[8]);
            double tireThreePressure = Double.parseDouble(token[9]);
            int tireThreeAge  = Integer.parseInt(token[10]);
            double tireFourPressure = Double.parseDouble(token[11]);
            int tireFourAge  = Integer.parseInt(token[12]);
            Car singleCar = new Car(model,
                    engineSpeed, enginePower,
                    cargoWeight, cargoType,
                    tireOnePressure, tireOneAge, tireTwoPressure, tireTwoAge, tireThreePressure, tireThreeAge, tireFourPressure, tireFourAge);
            carsInCatalog.get(cargoType).add(singleCar);
        }
        String command = console.nextLine();
        Predicate<Car> filter = getPredicate(command);
        carsInCatalog.get(command).stream().filter(Objects.requireNonNull(filter)).forEach(System.out::println);
    }

    private static Predicate<Car> getPredicate(String command) {
        switch (command){
            case "flamable":
                return s -> s.getEngine().getEnginePower()>250;
            case "fragile":
                return s ->s.getTire().getTireOnePressure() < 1 || s.getTire().getTireTwoPressure() < 1 || s.getTire().getTireThreePressure() < 1 || s.getTire().getTireFourPressure() < 1;
        }
        return null;
    }
}
