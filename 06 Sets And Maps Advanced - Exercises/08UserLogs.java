import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class UserLogs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        Map<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();
        while (!"end".equals(input = console.nextLine())) {
            String ip = input.substring(input.indexOf("=")+1, input.indexOf(" "));
            String user = input.substring(input.lastIndexOf("=")+1);
            logs.putIfAbsent(user, new LinkedHashMap<>());
            logs.get(user).putIfAbsent(ip, 0);
            logs.get(user).put(ip, logs.get(user).get(ip)+1);
        }
        System.out.println(logs.entrySet()
                .stream()
                .map(user ->
                        String.format("%s:%n%s.", user.getKey(),
                                user.getValue()
                                        .entrySet()
                                        .stream()
                                        .map(ip ->
                                                String.format("%s => %d",
                                                        ip.getKey(),
                                                        ip.getValue()))
                                        .collect(Collectors.joining(", "))
                        )
                )
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
