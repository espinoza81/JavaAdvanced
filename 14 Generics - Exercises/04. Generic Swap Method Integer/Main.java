package Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = Integer.parseInt(console.nextLine());
        List<Box> boxList = new ArrayList<>();
        while (number-- > 0){
            Box<Integer> box = new Box<>(Integer.parseInt(console.nextLine()));
            boxList.add(box);
        }
        int[] indexes = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Box.Swap(indexes[0], indexes[1], boxList);
        boxList.forEach(System.out::println);
    }
}
