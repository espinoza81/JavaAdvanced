import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int nameLength = Integer.parseInt(console.nextLine());
        List <String> names = Arrays.stream(console.nextLine().split("\\s+")).collect(Collectors.toList());
        Predicate <String> nameToPrint = s -> s.length()<=nameLength;
        Consumer<String> print = System.out::println;
        names.stream().filter(nameToPrint).forEach(print);
    }
}
