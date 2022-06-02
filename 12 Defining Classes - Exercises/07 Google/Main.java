package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Map<String, Person> personList = new HashMap<>();
        String inputLine;
        while (!"End".equals(inputLine = console.nextLine())) {
            String[] token = inputLine.split("\\s+");
            String name = token[0];
            personList.putIfAbsent(name, new Person(name));
            Person singlePerson = personList.get(name);
            switch (token[1]) {
                case "company":
                    singlePerson.setCompany(new Company(token[2], token[3], Double.parseDouble(token[4])));
                    break;
                case "car":
                    singlePerson.setCar(new Car(token[2], Integer.parseInt(token[3])));
                    break;
                case "pokemon":
                    singlePerson.addPokemon(new Pokemon(token[2], token[3]));
                    break;
                case "parents":
                    singlePerson.addParent(new Parent(token[2], token[3]));
                    break;
                case "children":
                    singlePerson.addChild(new Children(token[2], token[3]));
                    break;
            }
        }
        System.out.println(personList.get(console.nextLine()));
    }
}
