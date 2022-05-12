import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        HashMap<String, Integer> robotProcessTime = new LinkedHashMap<>();
        HashMap<String, LocalDateTime> robotBusy = new LinkedHashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Arrays.stream(console.nextLine().split(";"))
                .forEach(s -> {
                    String name = s.split("-")[0];
                    int processTime = Integer.parseInt(s.split("-")[1]);
                    robotProcessTime.put(name, processTime);
                    robotBusy.put(name, LocalDateTime.parse(LocalDate.now() + "T00:00:00"));
                });
        String time = console.nextLine();
        if(time.length()==7) {
            time = LocalDate.now() + "T0" + time;
        }
        else {
            time = LocalDate.now() + "T" + time;
        }
        LocalDateTime starTime = LocalDateTime.parse(time);
        ArrayDeque<String> products = new ArrayDeque<>();
        String product;
        while (!"End".equals(product = console.nextLine())) {
            starTime = starTime.plusSeconds(1);
            LocalDateTime finalStarTime = starTime;
            Optional<Map.Entry<String, LocalDateTime>> tempRobot = robotBusy.entrySet().stream().filter(s -> s.getValue().compareTo(finalStarTime) <= 0).findFirst();
            if (tempRobot.isPresent()) {
                robotBusy.put(tempRobot.get().getKey(), starTime.plusSeconds(robotProcessTime.get(tempRobot.get().getKey())));
                System.out.println(tempRobot.get().getKey() + " - " + product + " [" + starTime.format(formatter) + "]");
            } else {
                products.offer(product);
            }
        }
        while (!products.isEmpty()) {
            product = products.poll();
            starTime = starTime.plusSeconds(1);
            LocalDateTime finalStarTime = starTime;
            Optional<Map.Entry<String, LocalDateTime>> tempRobot = robotBusy.entrySet().stream().filter(s -> s.getValue().compareTo(finalStarTime) <= 0).findFirst();
            if (tempRobot.isPresent()) {
                robotBusy.put(tempRobot.get().getKey(), starTime.plusSeconds(robotProcessTime.get(tempRobot.get().getKey())));
                System.out.println(tempRobot.get().getKey() + " - " + product + " [" + starTime.format(formatter) + "]");
            } else {
                products.offer(product);
            }
        }
    }
}
