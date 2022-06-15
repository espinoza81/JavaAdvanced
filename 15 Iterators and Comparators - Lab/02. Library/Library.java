package Iterators;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new Iterator<>() {
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < books.length;
            }

            @Override
            public Book next() {
                return books[counter++];
            }
        };
    }
}
