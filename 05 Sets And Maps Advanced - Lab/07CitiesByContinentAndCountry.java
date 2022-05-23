import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int inputLine = Integer.parseInt(console.nextLine());
        Map<String, LinkedHashMap<String, List<String>>> countries = new LinkedHashMap<>();
        for (int i = 0; i < inputLine; i++) {
            String[] attribute = console.nextLine().split("\\s+");
            String continent = attribute[0];
            String country = attribute[1];
            String city = attribute[2];

            countries.putIfAbsent(continent, new LinkedHashMap<>());
            countries.get(continent).putIfAbsent(country, new ArrayList<>());
            countries.get(continent).get(country).add(city);
        }
        countries.forEach((continent, value) -> {
            System.out.println(continent + ":");
            value.forEach((country, city) -> System.out.println("  " + country + " -> " + String.join(", ", city)));
        });
    }
}
