package PokemonTrainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, Trainer> trainerList = new LinkedHashMap<>();
        String inputLine;
        while (!"Tournament".equals(inputLine= console.nextLine())){
            String[] token = inputLine.split("\\s+");
            trainerList.putIfAbsent(token[0], new Trainer(token[0]));
            Trainer singleTrainer = trainerList.get(token[0]);
            singleTrainer.addPokemon(new Pokemon(token[1], token[2], Integer.parseInt(token[3])));
        }
        String element;
        while (!"End".equals(element= console.nextLine())){
            String finalElement = element;
            trainerList.values().forEach(s -> s.applyCommand(finalElement));
        }
        trainerList.values().stream().sorted(Comparator.comparing(Trainer::getBadges).reversed()).forEach(System.out::println);
    }
}
