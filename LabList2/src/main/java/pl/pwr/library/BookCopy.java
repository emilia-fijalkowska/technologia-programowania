package pl.pwr.library;

// GRASP Information Expert: BookCopy przechowuje informację
// o stanie egzemplarza i sam zarządza jego dostępnością.
// High Cohesion: klasa odpowiada wyłącznie za pojedynczy egzemplarz.
public class BookCopy {
    private final int id;
    private final Book book;
    private boolean borrowed;

    public BookCopy(int id, Book book) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Copy ID must be positive.");
        }

        if (book == null) {
            throw new IllegalArgumentException(
                    "Book cannot be null.");
        }

        this.id = id;
        this.book = book;
        this.borrowed = false;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void borrow() {
        if (borrowed) {
            throw new IllegalStateException(
                    "This copy is already borrowed.");
        }

        borrowed = true;
    }

    public void returnCopy() {
        if (!borrowed) {
            throw new IllegalStateException(
                    "This copy has not been borrowed.");
        }

        borrowed = false;
    }

    @Override
    public String toString() {
        return "Copy #" + id + ": " + book.getTitle()
                + (borrowed ? " (borrowed)" : " (available)");
    }
}
