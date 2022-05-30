import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Predicate <String> upperCasePredicate = word -> Character.isUpperCase(word.charAt(0));
        Consumer <String> printer = System.out::println;
        List<String> upperCaseWords = Arrays.stream(console.nextLine().split("\\s+"))
                .filter(upperCasePredicate)
                .collect(Collectors.toList());

        System.out.println(upperCaseWords.size());
        upperCaseWords.forEach(printer);
    }
}
