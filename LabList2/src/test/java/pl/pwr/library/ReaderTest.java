package pl.pwr.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    @Test
    void shouldCreateReaderWithValidData() {
        Reader reader = new Reader(
                1,
                "Anna Kowalska",
                "anna@example.com");

        assertEquals(1, reader.getId());
        assertEquals("Anna Kowalska", reader.getName());
        assertEquals("anna@example.com", reader.getEmail());
    }

    @Test
    void shouldTrimTextFields() {
        Reader reader = new Reader(
                1,
                " Anna Kowalska ",
                " anna@example.com ");

        assertEquals("Anna Kowalska", reader.getName());
        assertEquals("anna@example.com", reader.getEmail());
    }

    @Test
    void shouldThrowExceptionWhenIdIsNotPositive() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Reader(0, "Anna", "anna@example.com"));
    }

    @Test
    void shouldThrowExceptionWhenNameIsBlank() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Reader(1, " ", "anna@example.com"));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsBlank() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Reader(1, "Anna", " "));
    }
}