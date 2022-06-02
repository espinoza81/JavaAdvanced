package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int line = Integer.parseInt(console.nextLine());
        Map <String, Engine> engineInCatalog = new HashMap<>();
        List<Car> carsInCatalog = new ArrayList<>();

        while (line-- > 0) {
            String[] token = console.nextLine().split("\\s+");
            String model = token[0];
            int power = Integer.parseInt(token[1]);
            Engine singleEngine = null;

            if (token.length==2)  singleEngine = new Engine(model, power);
            if (token.length==3) {
                if (token[2].chars().allMatch(Character::isDigit))
                    singleEngine = new Engine(model, power, Integer.parseInt(token[2]));
                else singleEngine = new Engine(model, power, token[2]);
            }
            if (token.length==4)   singleEngine = new Engine(model, power, Integer.parseInt(token[2]), token[3]);

            engineInCatalog.put(model, singleEngine);
        }

        line = Integer.parseInt(console.nextLine());
        while (line-- > 0) {
            String[] token = console.nextLine().split("\\s+");
            String model = token[0];
            String engine = token[1];
            Car singleCar = null;
            Engine tempEngine = engineInCatalog.get(engine);

            if (token.length==2)  singleCar = new Car(model, tempEngine);
            if (token.length==3) {
                if (token[2].chars().allMatch(Character::isDigit)) singleCar = new Car(model, tempEngine, Integer.parseInt(token[2]));
                else singleCar = new Car(model, tempEngine, token[2]);
            }
            if (token.length==4)   singleCar = new Car(model, tempEngine, Integer.parseInt(token[2]), token[3]);
            carsInCatalog.add(singleCar);

        }
        carsInCatalog.forEach(System.out::println);
    }
}
