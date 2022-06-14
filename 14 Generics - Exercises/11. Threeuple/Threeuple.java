package Generics;

public class Threeuple<F, S, T> {

    private F item1;
    private S item2;
    private T item3;

    public Threeuple(F item1, S item2, T item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        //"{item1} -> {item2} -> {item3}"
        return item1 + " -> " + item2 + " -> " + item3;
    }
}
