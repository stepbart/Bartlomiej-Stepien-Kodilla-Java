package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        // Given
        Book book1 = new Book("Platon","Państwo",2004,"9788379982516");
        Book book2 = new Book("Jiddu Krishnamurti","O Życiu i śmierci",2018,"9788366388550");
        Book book3 = new Book("Stanisław Beniowski","Nadzieje wiecznotrwałe",2021,"9788382196481");
        Book book4 = new Book("Marek Aureliusz","Rozmyślania",2000,"9788379983216");
        Book book5 = new Book("Johan Huizinga","Jesień Średniowiecza",1976,"9788379982899");

        MedianAdapter medianAdapter = new MedianAdapter();

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        // When
        int median = medianAdapter.publicationYearMedian(bookSet);
        // Then
        System.out.println(median);
        assertEquals(median, 2004, 0);
    }
}
