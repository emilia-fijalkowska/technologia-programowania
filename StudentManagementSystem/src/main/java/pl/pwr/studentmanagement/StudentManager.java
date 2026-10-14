package pl.pwr.studentmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentManager {

    private final List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        if (findStudent(student.getIndexNumber()).isPresent()) {
            return false;
        }

        students.add(student);
        return true;
    }

    public List<Student> getAllStudents() {
        return List.copyOf(students);
    }

    public Optional<Student> findStudent(String indexNumber) {
        return students.stream()
                .filter(student -> student.getIndexNumber().equals(indexNumber))
                .findFirst();
    }

    public boolean removeStudent(String indexNumber) {
        return students.removeIf(student -> student.getIndexNumber().equals(indexNumber));
    }
}