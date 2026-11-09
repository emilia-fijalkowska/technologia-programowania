package pl.pwr.library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        ConsoleUI consoleUI = new ConsoleUI(library);
        consoleUI.start();
    }
}
