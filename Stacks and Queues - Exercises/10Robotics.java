import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Robotics {
    public static class Robot {
        String name;
        int processTime;
        LocalDateTime endTime = LocalDateTime.parse(LocalDate.now() + "T00:00:00");

        public String getName() {
            return name;
        }

        public int getProcessTime() {
            return processTime;
        }

        public LocalDateTime getEndTime() {
            return endTime;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setProcessTime(int processTime) {
            this.processTime = processTime;
        }

        public void setEndTime(LocalDateTime endTime) {
            this.endTime = endTime;
        }

        public Robot(String name, int processTime) {
            this.name = name;
            this.processTime = processTime;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        HashMap<String, Robot> allRobots = new LinkedHashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Arrays.stream(console.nextLine().split(";"))
                .forEach(s -> {
                    String name = s.split("-")[0];
                    int processTime = Integer.parseInt(s.split("-")[1]);
                    Robot newRobot = new Robot(name, processTime);
                    allRobots.put(name, newRobot);
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
            starTime = getLocalDateTime(allRobots, formatter, starTime, products, product);
        }
        while (!products.isEmpty()) {
            product = products.poll();
            starTime = getLocalDateTime(allRobots, formatter, starTime, products, product);
        }
    }

    private static LocalDateTime getLocalDateTime(HashMap<String, Robot> allRobots, DateTimeFormatter formatter, LocalDateTime starTime, ArrayDeque<String> products, String product) {
        starTime = starTime.plusSeconds(1);
        LocalDateTime finalStarTime = starTime;
        Optional<Map.Entry<String, Robot>> tempRobot = allRobots.entrySet().stream().filter(s -> s.getValue().endTime.compareTo(finalStarTime) <= 0).findFirst();
        if (tempRobot.isPresent()) {
            allRobots.get(tempRobot.get().getKey()).setEndTime(starTime.plusSeconds(tempRobot.get().getValue().getProcessTime()));
            System.out.println(tempRobot.get().getKey() + " - " + product + " [" + starTime.format(formatter) + "]");
        } else {
            products.offer(product);
        }
        return starTime;
    }
}
