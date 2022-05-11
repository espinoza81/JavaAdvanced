import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        HashMap<String, Integer> robotProcessTime = new LinkedHashMap<>();
        HashMap<String, LocalTime> robotBusy = new LinkedHashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Arrays.stream(console.nextLine().split(";"))
                .forEach(s -> {
                    String name = s.split("-")[0];
                    int processTime = Integer.parseInt(s.split("-")[1]);
                    robotProcessTime.put(name, processTime);
                    robotBusy.put(name, LocalTime.parse("00:00:00", formatter));
                });
        String time = console.nextLine();
        if(time.length()==7) time = "0" + time;
        LocalTime starTime = LocalTime.parse(time, formatter);
        ArrayDeque<String> products = new ArrayDeque<>();
        String product;
        while (!"End".equals(product = console.nextLine())) {
            starTime = starTime.plusSeconds(1);
            String tempRobot = robotBusy.entrySet().stream().min(Map.Entry.comparingByValue()).stream().findFirst().get().getKey();
            if (robotBusy.get(tempRobot).compareTo(starTime) <= 0) {
                robotBusy.put(tempRobot, starTime.plusSeconds(robotProcessTime.get(tempRobot)));
                System.out.println(tempRobot + " - " + product + " [" + starTime.format(formatter) + "]");
            } else {
                products.offer(product);
            }
        }
        while (!products.isEmpty()) {
            starTime = starTime.plusSeconds(1);
            String tempRobot = robotBusy.entrySet().stream().min(Map.Entry.comparingByValue()).stream().findFirst().get().getKey();
            if (robotBusy.get(tempRobot).compareTo(starTime) <= 0) {
                robotBusy.put(tempRobot, starTime.plusSeconds(robotProcessTime.get(tempRobot)));
                System.out.println(tempRobot + " - " + products.poll() + " [" + starTime.format(formatter) + "]");
            } else {
                products.offer(products.poll());
            }
        }
    }
}
