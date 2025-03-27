package org.example;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Cours {
    private static int counter = 1;
    private int coursId;
    private String coursName;
    private int coursCode;
    private int creditHours; // 🔥 Ajouté
    private final List<Student> enrolledStudents;



    public Cours(String coursName, int coursCode) {
        this.coursId = counter++;
        this.coursName = coursName;
        this.coursCode = coursCode;
        this.creditHours = creditHours;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        if (student != null && !enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void removeStudent(Student student) {
        if (student != null) {
            enrolledStudents.remove(student);
        }
    }

    public List<Student> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents); // Retourne une copie de la liste
    }
}


