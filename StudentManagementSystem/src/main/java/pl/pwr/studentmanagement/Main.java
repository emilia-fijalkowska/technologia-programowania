package pl.pwr.studentmanagement;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                printMenu();
                System.out.print("Wybierz opcje: ");
                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1" -> addStudent(scanner, manager);
                    case "2" -> displayStudents(manager);
                    case "3" -> searchStudent(scanner, manager);
                    case "4" -> removeStudent(scanner, manager);
                    case "0" -> running = false;
                    default -> System.out.println(
                            "Nieprawidlowa opcja.");
                }

                System.out.println();
            }
        }

        System.out.println("Koniec programu.");
    }

    private static void printMenu() {
        System.out.println("=== STUDENT MANAGEMENT SYSTEM ===");
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Wyswietl wszystkich studentow");
        System.out.println("3. Wyszukaj studenta");
        System.out.println("4. Usun studenta");
        System.out.println("0. Wyjdz");
    }

    private static void addStudent(
            Scanner scanner, StudentManager manager) {

        System.out.print("Imię: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Nazwisko: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Numer indeksu: ");
        String indexNumber = scanner.nextLine().trim();

        if (firstName.isBlank()
                || lastName.isBlank()
                || indexNumber.isBlank()) {
            System.out.println("Żadne pole nie może być puste.");
            return;
        }

        Student student = new Student(
                firstName, lastName, indexNumber);

        if (manager.addStudent(student)) {
            System.out.println("Student został dodany!");
        } else {
            System.out.println(
                    "Student o tym numerze indeksu już istnieje.");
        }
    }

    private static void displayStudents(StudentManager manager) {
        List<Student> students = manager.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("Brak studentów na liscie.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent(
            Scanner scanner, StudentManager manager) {

        System.out.print("Podaj numer indeksu: ");
        String indexNumber = scanner.nextLine().trim();

        Optional<Student> student = manager.findStudent(indexNumber);

        if (student.isPresent()) {
            System.out.println(student.get());
        } else {
            System.out.println("Nie znaleziono studenta.");
        }
    }

    private static void removeStudent(
            Scanner scanner, StudentManager manager) {

        System.out.print("Podaj numer indeksu do usunięcia: ");
        String indexNumber = scanner.nextLine().trim();

        if (manager.removeStudent(indexNumber)) {
            System.out.println("Student został usuniety.");
        } else {
            System.out.println("Nie znaleziono studenta.");
        }
    }
}