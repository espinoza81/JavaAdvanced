package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int line = Integer.parseInt(console.nextLine());
        Map<String, Car> carList = new LinkedHashMap<>();

        while (line-- > 0) {
            String[] token = console.nextLine().split("\\s+");
            Car singleCar = new Car(token[0], Double.parseDouble(token[1]), Double.parseDouble(token[2]));
            carList.put(token[0], singleCar);
        }

        String command;
        while (!"End".equals(command = console.nextLine())) {
            String carModel = command.split("\\s+")[1];
            double amountOfKm = Double.parseDouble(command.split("\\s+")[2]);
            Car temp = carList.get(carModel);
            temp.move(temp, amountOfKm);
        }
        carList.values().forEach(System.out::println);
    }
}
