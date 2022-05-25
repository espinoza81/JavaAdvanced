import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int inputLine = Integer.parseInt(console.nextLine());
        Set<String> inputs = new LinkedHashSet<>();
        for (int i = 0; i < inputLine; i++) {
            String inputToAdd = console.nextLine();
            inputs.add(inputToAdd);
        }
        for (String input : inputs) {
            System.out.println(input);
        }
    }
}
