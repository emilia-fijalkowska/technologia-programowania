package pl.pwr.library;

import java.util.ArrayList;
import java.util.List;

// GRASP Information Expert: Library zarządza danymi biblioteki
// i odpowiada za operacje na książkach, egzemplarzach i czytelnikach.
public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<BookCopy> copies = new ArrayList<>();
    private final List<Reader> readers = new ArrayList<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException(
                    "Book cannot be null.");
        }

        if (books.contains(book)) {
            throw new IllegalArgumentException(
                    "This book already exists in the library.");
        }

        books.add(book);
    }

    public void addCopy(BookCopy copy) {
        if (copy == null) {
            throw new IllegalArgumentException(
                    "Book copy cannot be null.");
        }

        if (!books.contains(copy.getBook())) {
            throw new IllegalArgumentException(
                    "Add the book to the library first.");
        }

        for (BookCopy existingCopy : copies) {
            if (existingCopy.getId() == copy.getId()) {
                throw new IllegalArgumentException(
                        "A copy with this ID already exists.");
            }
        }

        copies.add(copy);
    }

    public void addReader(Reader reader) {
        if (reader == null) {
            throw new IllegalArgumentException(
                    "Reader cannot be null.");
        }

        for (Reader existingReader : readers) {
            if (existingReader.getId() == reader.getId()) {
                throw new IllegalArgumentException(
                        "A reader with this ID already exists.");
            }
        }

        readers.add(reader);
    }

    public void addLoan(Reader reader, BookCopy copy) {
        if (reader == null || copy == null) {
            throw new IllegalArgumentException(
                    "Reader and book copy cannot be null.");
        }

        if (!readers.contains(reader)) {
            throw new IllegalArgumentException(
                    "Reader is not registered in the library.");
        }

        if (!copies.contains(copy)) {
            throw new IllegalArgumentException(
                    "This copy does not belong to the library.");
        }

        if (copy.isBorrowed()) {
            throw new IllegalStateException(
                    "This copy is already borrowed.");
        }
        copy.borrow();

        // GRASP Creator: Library tworzy Loan, ponieważ przechowuje
        // wypożyczenia i posiada obiekty Reader oraz BookCopy.
        Loan loan = new Loan(reader, copy);
        loans.add(loan);
    }

    public void returnBook(BookCopy copy) {
        if (copy == null) {
            throw new IllegalArgumentException(
                    "Book copy cannot be null.");
        }

        if (!copies.contains(copy)) {
            throw new IllegalArgumentException(
                    "This copy does not belong to the library.");
        }

        if (!copy.isBorrowed()) {
            throw new IllegalStateException(
                    "This copy has not been borrowed.");
        }

        copy.returnCopy();

        Loan loanToRemove = null;

        for (Loan loan : loans) {
            if (loan.getBookCopy() == copy) {
                loanToRemove = loan;
                break;
            }
        }

        if (loanToRemove != null) {
            loans.remove(loanToRemove);
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("Books in the library:");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayCopies() {
        if (copies.isEmpty()) {
            System.out.println("No book copies in the library.");
            return;
        }

        System.out.println("Book copies in the library:");

        for (BookCopy copy : copies) {
            System.out.println(copy);
        }
    }

    public void displayReaders() {
        if (readers.isEmpty()) {
            System.out.println("No readers registered.");
            return;
        }

        System.out.println("Registered readers:");

        for (Reader reader : readers) {
            System.out.println(reader);
        }
    }

    public void displayLoans() {
        if (loans.isEmpty()) {
            System.out.println("No active loans.");
            return;
        }

        System.out.println("Active loans:");

        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public List<Reader> getReaders() {
        return new ArrayList<>(readers);
    }

    public List<BookCopy> getCopies() {
        return new ArrayList<>(copies);
    }
}
