package pl.pwr.library;

import java.util.Objects;

// High Cohesion: Book odpowiada wyłącznie za dane
// i tożsamość tytułu książki.
public class Book {
    private final String isbn; // identyfikator ksiazki international standart book number
    private final String title; // tytul
    private final String author; // autor

    // KONSTRUKTOR -> tworzymy obiekt ksiazki
    public Book(String isbn, String title, String author) {
        this.isbn = requireText(isbn, "ISBN");
        this.title = requireText(title, "Title");
        this.author = requireText(author, "Author");
    }

    // METODA - sprawdza czy przekazany tekst istnieje
    private static String requireText(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    field + " cannot be empty.");
        }

        return value.trim();
    }

    // GETTERY
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + " - " + author + " (ISBN: " + isbn + ")";
    }

    // METODA - okresla kiedy dwa obiekty Book uznajemy za rowne
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Book book)) {
            return false;
        }

        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
