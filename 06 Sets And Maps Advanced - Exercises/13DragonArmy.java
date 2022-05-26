import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, HashMap<String,int[]>> dragons = new LinkedHashMap<>();
        int number = Integer.parseInt(console.nextLine());
        for(int i=0; i<number; i++){
            String[] command = console.nextLine().split("\\s+");
            //{type} {name} {damage} {health} {armor}
            String type = command[0];
            String name = command[1];
            int damage = "null".equals(command[2])? 45 : Integer.parseInt(command[2]);
            int health = "null".equals(command[3])? 250 : Integer.parseInt(command[3]);
            int armor = "null".equals(command[4])? 10 : Integer.parseInt(command[4]);
            int[] stats = new int[]{damage, health, armor};
            dragons.putIfAbsent(type, new LinkedHashMap<>());
            dragons.get(type).put(name, stats);
        }

        dragons.forEach((key, value) -> {
            double damage = 0.00;
            double health = 0.00;
            double armor = 0.00;
            double count = 0.00;
            for (int[] stats : value.values()) {
                damage += stats[0];
                health += stats[1];
                armor += stats[2];
                count++;
            }
            damage /= count;
            health /= count;
            armor /= count;
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key, damage, health, armor);
            value.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(s ->
                            System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", s.getKey(), s.getValue()[0], s.getValue()[1], s.getValue()[2]));
        });
    }
}
