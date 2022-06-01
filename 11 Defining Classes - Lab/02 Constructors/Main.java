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
            Car car = token.length == 1 ? new Car(token[0]) : new Car(token[0], token[1],  Integer.parseInt(token[2]));
            cars.add(car);
        }
        cars.forEach(car -> System.out.println(car.carInfo()));
    }
}
