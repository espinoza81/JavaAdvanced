import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input;
        Map<String, Integer> cardsPoint = new LinkedHashMap<>();
        Map<String, LinkedHashSet<String>> uniqueCards = new LinkedHashMap<>();
        Map<Character, Integer> cardValue = new LinkedHashMap<>();
        Map<Character, Integer> cardType = new LinkedHashMap<>();
        cardValue.put('J', 11);
        cardValue.put('Q', 12);
        cardValue.put('K', 13);
        cardValue.put('A', 14);
        cardType.put('C', 1);
        cardType.put('D', 2);
        cardType.put('H', 3);
        cardType.put('S', 4);
        while (!"JOKER".equals(input = console.nextLine())) {
            String name = input.split(":\\s+")[0];
            cardsPoint.putIfAbsent(name, 0);
            uniqueCards.putIfAbsent(name, new LinkedHashSet<>());
            String[] cards = input.split(":\\s+")[1].split(",\\s+");
            int points=0;
            for (String card : cards) {
                if(uniqueCards.get(name).add(card)){
                    points += (cardValue.containsKey(card.charAt(0)) 
                            ? cardValue.get(card.charAt(0)) 
                            : Integer.parseInt(card.substring(0, card.length()-1))) 
                            * cardType.get(card.charAt(card.length()-1));
                }
            }
            cardsPoint.put(name, cardsPoint.get(name)+ points);
        }
        cardsPoint.forEach((k, v)-> System.out.println(k + ": " + v));
    }
}
