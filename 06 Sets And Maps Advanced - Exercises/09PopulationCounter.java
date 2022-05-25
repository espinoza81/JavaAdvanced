import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        Map<String, Long> totalCountryPopulation = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, Long>> populationByCity = new LinkedHashMap<>();
        while (!"report".equals(input = console.nextLine())) {
            String[] attributes = input.split("\\|");
            String city = attributes[0];
            String country = attributes[1];
            Long population = Long.parseLong(attributes[2]);
            totalCountryPopulation.putIfAbsent(country, 0L);
            totalCountryPopulation.put(country, totalCountryPopulation.get(country)+population);
            populationByCity.putIfAbsent(country, new LinkedHashMap<>());
            populationByCity.get(country).putIfAbsent(city, population);
        }
        totalCountryPopulation.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(s -> System.out.printf("%s (total population: %d)%n%s%n",
                        s.getKey(),
                        s.getValue(),
                        populationByCity.get(s.getKey())
                                .entrySet()
                                .stream()
                                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                .map(city ->
                                        String.format("=>%s: %d",
                                                city.getKey(),
                                                city.getValue()))
                                .collect(Collectors.joining(System.lineSeparator()))));
    }
}
