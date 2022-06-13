package Generics;

import java.util.List;

public class Box<E> {
    private E element;

    public Box(E element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element.getClass().getName() + ": " + element;
    }

    public static void Swap(int indexFirst, int indexSecond, List<Box> boxList){
        Box tempBox = boxList.get(indexFirst);
        boxList.set(indexFirst, boxList.get(indexSecond));
        boxList.set(indexSecond, tempBox);
    }
}
