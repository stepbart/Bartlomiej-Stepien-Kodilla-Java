package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    void testGetBooks() throws CloneNotSupportedException {
        //Given
        Book book1 = new Book("Test Title", "Test Author", LocalDate.of(1999, 1, 15));
        Book book2 = book1.clone();
        Book book3 = book1.clone();
        Book book4 = book1.clone();
        Book book5 = book1.clone();

        Library library = new Library("First Library");
        library.addBooks(book1, book2, book3, book4, book5);

        //When
        //creating shallow copy of library
        Library shallowCopyLibrary = library.shallowCopy();

        //creating deep copy of library
        Library deepCopyLibrary = library.deepCopy();

        //removing 4 of 5 books from shallow copy of library
        shallowCopyLibrary.getBooks().remove(book1);
        shallowCopyLibrary.getBooks().remove(book2);
        shallowCopyLibrary.getBooks().remove(book3);
        shallowCopyLibrary.getBooks().remove(book4);

        //Then
        Assertions.assertEquals(library.getBooks().size(), 1);
        Assertions.assertEquals(shallowCopyLibrary.getBooks().size(), 1);
        Assertions.assertEquals(deepCopyLibrary.getBooks().size(), 5);
    }
}
