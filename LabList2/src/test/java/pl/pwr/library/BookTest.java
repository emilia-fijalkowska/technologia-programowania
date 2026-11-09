package pl.pwr.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldCreateBookWithValidData() {
        Book book = new Book(
                "978-83-123456-0-0",
                "The Hobbit",
                "J.R.R. Tolkien");

        assertEquals("978-83-123456-0-0", book.getIsbn());
        assertEquals("The Hobbit", book.getTitle());
        assertEquals("J.R.R. Tolkien", book.getAuthor());
    }

    @Test
    void shouldTrimTextFields() {
        Book book = new Book(
                " 978-83-123456-0-0 ",
                " The Hobbit ",
                " J.R.R. Tolkien ");

        assertEquals("978-83-123456-0-0", book.getIsbn());
        assertEquals("The Hobbit", book.getTitle());
        assertEquals("J.R.R. Tolkien", book.getAuthor());
    }

    @Test
    void shouldThrowExceptionWhenTitleIsBlank() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Book("123", " ", "Author"));
    }

    @Test
    void booksWithSameIsbnShouldBeEqual() {
        Book first = new Book("123", "Book A", "Author A");
        Book second = new Book("123", "Book B", "Author B");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }
}