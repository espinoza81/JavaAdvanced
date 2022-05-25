import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        Map<String, String> phonebook = new LinkedHashMap<>();
        while (!"search".equals(input= console.nextLine())){
            String name = input.split("-")[0];
            String phoneNumber = input.split("-")[1];
            phonebook.put(name, phoneNumber);
        }
        while (!"stop".equals(input= console.nextLine())){
            if(phonebook.containsKey(input)) {
                System.out.println(input + " -> " + phonebook.get(input));
            }
            else {
                System.out.println("Contact " + input + " does not exist.");
            }
        }
    }
}
