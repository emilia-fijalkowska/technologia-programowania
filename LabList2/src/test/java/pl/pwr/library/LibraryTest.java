package pl.pwr.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void shouldAddBook() {
        Library library = new Library();
        Book book = new Book("123", "The Hobbit", "Tolkien");

        library.addBook(book);

        assertEquals(1, library.getBooks().size());
        assertEquals(book, library.getBooks().get(0));
    }

    @Test
    void shouldNotAddBookWithDuplicateIsbn() {
        Library library = new Library();

        Book first = new Book("123", "The Hobbit", "Tolkien");
        Book second = new Book("123", "Another title", "Another author");

        library.addBook(first);

        assertThrows(
                IllegalArgumentException.class,
                () -> library.addBook(second));
    }

    @Test
    void shouldAddBookCopy() {
        Library library = new Library();
        Book book = new Book("123", "The Hobbit", "Tolkien");
        BookCopy copy = new BookCopy(1, book);

        library.addBook(book);
        library.addCopy(copy);

        assertEquals(1, library.getCopies().size());
        assertEquals(copy, library.getCopies().get(0));
    }

    @Test
    void shouldNotAddCopyOfBookThatDoesNotExist() {
        Library library = new Library();

        Book book = new Book("123", "The Hobbit", "Tolkien");
        BookCopy copy = new BookCopy(1, book);

        assertThrows(
                IllegalArgumentException.class,
                () -> library.addCopy(copy));
    }

    @Test
    void shouldAddReader() {
        Library library = new Library();
        Reader reader = new Reader(
                1, "Anna Kowalska", "anna@example.com");

        library.addReader(reader);

        assertEquals(1, library.getReaders().size());
        assertEquals(reader, library.getReaders().get(0));
    }

    @Test
    void shouldNotAddReaderWithDuplicateId() {
        Library library = new Library();

        Reader first = new Reader(
                1, "Anna Kowalska", "anna@example.com");

        Reader second = new Reader(
                1, "Jan Nowak", "jan@example.com");

        library.addReader(first);

        assertThrows(
                IllegalArgumentException.class,
                () -> library.addReader(second));
    }

    @Test
    void shouldBorrowBookCopy() {
        Library library = new Library();

        Book book = new Book("123", "The Hobbit", "Tolkien");
        BookCopy copy = new BookCopy(1, book);
        Reader reader = new Reader(
                1, "Anna Kowalska", "anna@example.com");

        library.addBook(book);
        library.addCopy(copy);
        library.addReader(reader);

        library.addLoan(reader, copy);

        assertTrue(copy.isBorrowed());
    }

    @Test
    void shouldNotBorrowAlreadyBorrowedCopy() {
        Library library = new Library();

        Book book = new Book("123", "The Hobbit", "Tolkien");
        BookCopy copy = new BookCopy(1, book);
        Reader reader = new Reader(
                1, "Anna Kowalska", "anna@example.com");

        library.addBook(book);
        library.addCopy(copy);
        library.addReader(reader);

        library.addLoan(reader, copy);

        assertThrows(
                IllegalStateException.class,
                () -> library.addLoan(reader, copy));
    }

    @Test
    void shouldReturnBorrowedBookCopy() {
        Library library = new Library();

        Book book = new Book("123", "The Hobbit", "Tolkien");
        BookCopy copy = new BookCopy(1, book);
        Reader reader = new Reader(
                1, "Anna Kowalska", "anna@example.com");

        library.addBook(book);
        library.addCopy(copy);
        library.addReader(reader);

        library.addLoan(reader, copy);
        library.returnBook(copy);

        assertFalse(copy.isBorrowed());
    }

    @Test
    void shouldNotReturnAvailableBookCopy() {
        Library library = new Library();

        Book book = new Book("123", "The Hobbit", "Tolkien");
        BookCopy copy = new BookCopy(1, book);

        library.addBook(book);
        library.addCopy(copy);

        assertThrows(
                IllegalStateException.class,
                () -> library.returnBook(copy));
    }
}