import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        Map<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();
        while (!"stop".equals(input = console.nextLine())) {
            String ip = input.substring(input.indexOf("=")+1, input.indexOf(" "));
            String user = input.substring(input.lastIndexOf("=")+1);
            logs.putIfAbsent(user, new LinkedHashMap<>());
            logs.get(user).putIfAbsent(ip, 0);
            logs.get(user).put(ip, logs.get(user).get(ip)+1);
        }
        s
    }
}
