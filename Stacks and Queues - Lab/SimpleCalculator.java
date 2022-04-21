import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");
        ArrayDeque<String> calculation = new ArrayDeque<>();
        Collections.addAll(calculation, input);
        while (calculation.size()>1){
            sum(calculation.pop(), calculation.pop(), calculation.pop(), calculation);
        }
        System.out.println(calculation.peek());
    }

    private static void sum(String pop, String pop1, String pop2, ArrayDeque<String> calculation) {
        if("+".equals(pop1)) calculation.push(String.valueOf(Integer.parseInt(pop)+Integer.parseInt(pop2)));
        else calculation.push(String.valueOf(Integer.parseInt(pop)-Integer.parseInt(pop2)));
    }
}
