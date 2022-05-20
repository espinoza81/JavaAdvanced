import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input;
        Set<String> guests = new TreeSet<>();
        
        while (!"PARTY".equals(input = console.nextLine())){
            guests.add(input);
        }
        while (!"END".equals(input = console.nextLine())){
            guests.remove(input);
        }
        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
