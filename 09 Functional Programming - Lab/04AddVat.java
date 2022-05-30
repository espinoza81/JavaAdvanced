import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        UnaryOperator<Double> taxWhitVat = i -> i*1.2;
        Consumer<Double> printer = i -> System.out.printf("%.2f%n", i);
        Function <String, Double> parser = Double::parseDouble;
        
        System.out.println("Prices with VAT:");
        Arrays.stream(console.nextLine().split(",\\s+"))
                .map(parser)
                .map(taxWhitVat)
                .forEach(printer);
    }
}
