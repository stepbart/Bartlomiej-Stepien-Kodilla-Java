package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addBooks(Book... book) {
        for (Book b : book) {
            books.add(b);
        }
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library copyLibrary = super.clone();
        copyLibrary.books = new HashSet<>();
        for (Book book : books) {
            copyLibrary.addBook(book);
        }
        return copyLibrary;
    }

}