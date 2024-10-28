package com.crni99.bookstore.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    void testBookModel() {
        // Create a new Book object using the correct constructor
        Book book = new Book(
            1L, 
            "Spring in Action", 
            new BigDecimal("35.99"), 
            "Craig Walls", 
            "978-1617294945", 
            "Manning", 
            LocalDate.of(21, 6, 1)
        );

        // Assert the properties of the Book
        assertEquals(1L, book.getId());
        assertEquals("Spring in Action", book.getName()); // Corrected from getTitle()
        assertEquals(new BigDecimal("35.99"), book.getPrice());
        assertEquals("Craig Walls", book.getAuthors()); // Corrected from getAuthor()
        assertEquals("Manning", book.getPublisher());
        assertEquals("978-1617294945", book.getIsbn());
        assertEquals(LocalDate.of(2020, 6, 1), book.getPublishedOn()); // Corrected from getPublishDate()
    }
}
