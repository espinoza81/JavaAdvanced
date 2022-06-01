package CarInfo;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Set<Car> cars = new LinkedHashSet<>();
        int lineNumber = Integer.parseInt(console.nextLine());
        while (lineNumber-- > 0) {
            String[] token = console.nextLine().split("\\s+");
            String brand = token[0];
            Car car;
            if (token.length == 1) {
                car = new Car(brand);
            } else {
                String model = token[1];
                int horsePower = Integer.parseInt(token[2]);
                car = new Car(brand, model, horsePower);
            }
            cars.add(car);
        }
        cars.forEach(car -> System.out.println(car.carInfo()));
    }
}
