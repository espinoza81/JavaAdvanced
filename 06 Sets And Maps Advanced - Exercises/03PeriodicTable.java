import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int lineToInput = Integer.parseInt(console.nextLine());
        Set<String> chemicalElements = new TreeSet<>();
        for (int i=0; i< lineToInput; i++){
            String[] elements = console.nextLine().split("\\s+");
            chemicalElements.addAll(Arrays.asList(elements));
        }
        System.out.println(String.join(" ", chemicalElements));
    }
}
