package pl.pwr.library;

// High Cohesion: Loan reprezentuje pojedyncze wypożyczenie
// i przechowuje informacje o czytelniku oraz egzemplarzu.
public class Loan {
    private final Reader reader;
    private final BookCopy bookCopy;

    public Loan(Reader reader, BookCopy bookCopy) {
        if (reader == null) {
            throw new IllegalArgumentException(
                    "Reader cannot be null.");
        }

        if (bookCopy == null) {
            throw new IllegalArgumentException(
                    "Book copy cannot be null.");
        }

        this.reader = reader;
        this.bookCopy = bookCopy;
    }

    public Reader getReader() {
        return reader;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    // METODA - tekstowy opis wypozyczenia
    @Override
    public String toString() {
        return reader.getName() + " borrowed "
                + bookCopy.getBook().getTitle()
                + " (copy #" + bookCopy.getId() + ")";
    }
}
