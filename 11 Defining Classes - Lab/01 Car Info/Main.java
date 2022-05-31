package CarInfo;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Set <Car> cars = new LinkedHashSet<>();
        int lineNumber = Integer.parseInt(console.nextLine());
        for (int i = 0; i < lineNumber; i++) {
            String[] token = console.nextLine().split("\\s+");
            String brand = token[0];
            String model = token[1];
            int horsePower = Integer.parseInt(token[2]);
            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);
            cars.add(car);
        }
         cars.forEach(car -> System.out.println(car.carInfo()));
    }
}
