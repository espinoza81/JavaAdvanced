import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        Map<Character, Integer> symbols = new TreeMap<>();
        for( int i=0; i<input.length(); i++){
            char charToAdd = input.charAt(i);
            symbols.putIfAbsent(charToAdd, 0);
            symbols.put(charToAdd, symbols.get(charToAdd)+1);
        }
        symbols.forEach((k, v)-> System.out.printf("%s: %d time/s%n", k, v));
    }
}
