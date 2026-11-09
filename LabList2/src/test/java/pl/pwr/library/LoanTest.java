package pl.pwr.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoanTest {

    @Test
    void shouldCreateLoanWithValidData() {
        Reader reader = new Reader(
                1, "Anna Kowalska", "anna@example.com");

        Book book = new Book(
                "123", "The Hobbit", "Tolkien");

        BookCopy copy = new BookCopy(1, book);

        Loan loan = new Loan(reader, copy);

        assertEquals(reader, loan.getReader());
        assertEquals(copy, loan.getBookCopy());
    }

    @Test
    void shouldThrowExceptionWhenReaderIsNull() {
        Book book = new Book("123", "The Hobbit", "Tolkien");
        BookCopy copy = new BookCopy(1, book);

        assertThrows(
                IllegalArgumentException.class,
                () -> new Loan(null, copy));
    }

    @Test
    void shouldThrowExceptionWhenBookCopyIsNull() {
        Reader reader = new Reader(
                1, "Anna Kowalska", "anna@example.com");

        assertThrows(
                IllegalArgumentException.class,
                () -> new Loan(reader, null));
    }
}