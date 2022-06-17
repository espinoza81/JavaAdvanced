package Iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Lake implements Iterable<Integer> {
    private Node head;
    private int size;

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    private class Frog implements Iterator<Integer> {
        private Node current = head;
        int index;
        boolean oddIndexes;

        public Frog() {
            index = 0;
            oddIndexes = false;
        }

        @Override
        public boolean hasNext() {
            if (!oddIndexes) return true;
            return index < size;
        }

        @Override
        public Integer next() {
            int element = current.value;
            index += 2;
            if (index >= size && !oddIndexes) {
                current = head.next;
                oddIndexes = true;
                index = 1;
            } else if (index <= size) {
                current = current.next.next;
            }
            return element;
        }
    }

    public void addLast(int number) {
        Node newNode = new Node(number);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public static void print(Lake lake) {
        List<Integer> printLake = new ArrayList<>();
        for (Integer number : lake) {
            printLake.add(number);
        }
        System.out.println(printLake.stream().map(n -> String.format("%d", n)).collect(Collectors.joining(", ")));
    }
}
