import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        Map<String, String> emails = new LinkedHashMap<>();
        while (!"stop".equals(input = console.nextLine())) {
            String email = console.nextLine();
            String domain = email.substring(email.lastIndexOf(".")+1);
            if (!("us".equals(domain) || "uk".equals(domain) || "com".equals(domain))) {
                emails.put(input, email);
            }
        }
        emails.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
