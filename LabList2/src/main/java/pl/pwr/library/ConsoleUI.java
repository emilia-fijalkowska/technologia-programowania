package pl.pwr.library;

import java.util.Scanner;

// GRASP Controller: ConsoleUI obsługuje polecenia użytkownika
// i przekazuje odpowiednie operacje do klasy Library.
public class ConsoleUI {
    private final Library library;
    private final Scanner scanner;

    public ConsoleUI(Library library) {
        if (library == null) {
            throw new IllegalArgumentException(
                    "Library cannot be null.");
        }

        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            displayMenu();

            int choice = readInt("Choose an option: ");

            try {
                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> addBookCopy();
                    case 3 -> addReader();
                    case 4 -> borrowBook();
                    case 5 -> returnBook();
                    case 6 -> library.displayBooks();
                    case 7 -> library.displayCopies();
                    case 8 -> library.displayReaders();
                    case 9 -> library.displayLoans();
                    case 0 -> {
                        running = false;
                        System.out.println("Goodbye!");
                    }
                    default -> System.out.println(
                            "Invalid option. Try again.");
                }
            } catch (IllegalArgumentException
                    | IllegalStateException exception) {
                System.out.println(
                        "Error: " + exception.getMessage());
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n=== Library Menu ===");
        System.out.println("1. Add a book title");
        System.out.println("2. Add a book copy");
        System.out.println("3. Register a reader");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. Display book titles");
        System.out.println("7. Display book copies");
        System.out.println("8. Display readers");
        System.out.println("9. Display active loans");
        System.out.println("0. Exit");
    }

    private void addBook() {
        String isbn = readText("Enter ISBN: ");
        String title = readText("Enter book title: ");
        String author = readText("Enter author: ");

        Book book = new Book(isbn, title, author);
        library.addBook(book);

        System.out.println("Book title added successfully.");
    }

    private void addBookCopy() {
        int id = readInt("Enter copy ID: ");
        String isbn = readText(
                "Enter ISBN of the existing book: ");

        Book book = findBookByIsbn(isbn);

        BookCopy copy = new BookCopy(id, book);
        library.addCopy(copy);

        System.out.println("Book copy added successfully.");
    }

    private void addReader() {
        int id = readInt("Enter reader ID: ");
        String name = readText("Enter reader name: ");
        String email = readText("Enter reader email: ");

        Reader reader = new Reader(id, name, email);
        library.addReader(reader);

        System.out.println("Reader registered successfully.");
    }

    private void borrowBook() {
        int readerId = readInt("Enter reader ID: ");
        int copyId = readInt("Enter copy ID: ");

        Reader reader = findReaderById(readerId);
        BookCopy copy = findCopyById(copyId);

        library.addLoan(reader, copy);

        System.out.println("Book borrowed successfully.");
    }

    private void returnBook() {
        int copyId = readInt("Enter copy ID to return: ");

        BookCopy copy = findCopyById(copyId);
        library.returnBook(copy);

        System.out.println("Book returned successfully.");
    }

    private Book findBookByIsbn(String isbn) {
        for (Book book : library.getBooks()) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }

        throw new IllegalArgumentException(
                "Book with this ISBN was not found.");
    }

    private Reader findReaderById(int id) {
        for (Reader reader : library.getReaders()) {
            if (reader.getId() == id) {
                return reader;
            }
        }

        throw new IllegalArgumentException(
                "Reader with this ID was not found.");
    }

    private BookCopy findCopyById(int id) {
        for (BookCopy copy : library.getCopies()) {
            if (copy.getId() == id) {
                return copy;
            }
        }

        throw new IllegalArgumentException(
                "Book copy with this ID was not found.");
    }

    private String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println(
                        "Please enter a valid integer.");
            }
        }
    }
}
