import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double[] numbers = Arrays
                .stream(console.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        HashMap<Double, Integer> countOfNumbers = new LinkedHashMap<>();
        for (double number : numbers) {
            countOfNumbers.putIfAbsent(number, 0);
            countOfNumbers.put(number, countOfNumbers.get(number)+1);
        }
        countOfNumbers.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
