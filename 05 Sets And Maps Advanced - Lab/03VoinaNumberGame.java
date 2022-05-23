import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayerDeck = Arrays.stream(console.nextLine()
                        .split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondPlayerDeck = Arrays.stream(console.nextLine()
                        .split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(LinkedHashSet::new));

        for(int round=0; round< 50; round++){
            int firstPlayerCard = firstPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstPlayerCard);
            int secondPlayerCard = secondPlayerDeck.iterator().next();
            secondPlayerDeck.remove(secondPlayerCard);
            if (firstPlayerCard>secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            }
            else if(secondPlayerCard>firstPlayerCard){
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }
            else {
                firstPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }
            if(firstPlayerDeck.isEmpty() || secondPlayerDeck.isEmpty()) break;
        }

        if(firstPlayerDeck.size()>secondPlayerDeck.size()) System.out.println("First player win!");
        else if(firstPlayerDeck.size()<secondPlayerDeck.size()) System.out.println("Second player win!");
        else System.out.println("Draw!");
    }
}
