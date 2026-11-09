package pl.pwr.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookCopyTest {

    @Test
    void newCopyShouldBeAvailable() {
        Book book = new Book("123", "The Hobbit", "Tolkien");
        BookCopy copy = new BookCopy(1, book);

        assertEquals(1, copy.getId());
        assertEquals(book, copy.getBook());
        assertFalse(copy.isBorrowed());
    }

    @Test
    void shouldBorrowAvailableCopy() {
        Book book = new Book("123", "The Hobbit", "Tolkien");
        BookCopy copy = new BookCopy(1, book);

        copy.borrow();

        assertTrue(copy.isBorrowed());
    }

    @Test
    void shouldReturnBorrowedCopy() {
        Book book = new Book("123", "The Hobbit", "Tolkien");
        BookCopy copy = new BookCopy(1, book);

        copy.borrow();
        copy.returnCopy();

        assertFalse(copy.isBorrowed());
    }

    @Test
    void shouldNotBorrowAlreadyBorrowedCopy() {
        Book book = new Book("123", "The Hobbit", "Tolkien");
        BookCopy copy = new BookCopy(1, book);

        copy.borrow();

        assertThrows(
                IllegalStateException.class,
                copy::borrow);
    }

    @Test
    void shouldNotReturnAvailableCopy() {
        Book book = new Book("123", "The Hobbit", "Tolkien");
        BookCopy copy = new BookCopy(1, book);

        assertThrows(
                IllegalStateException.class,
                copy::returnCopy);
    }
}