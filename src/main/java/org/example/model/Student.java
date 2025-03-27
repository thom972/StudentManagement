package org.example;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Student extends Person {
    private static int counter = 1; // Pour générer des IDs uniques
    private final int studentId;
    private final List<Double> grades;

    public Student(String name, int age) {
        super(name, age);
        this.studentId = counter++;
        this.grades = new ArrayList<>();
    }

    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    public void addGrade(Double grade) {
        if (grades != null && grade >= 0) {
            grades.add(grade);
        }
    }

    public double getAverageGrade() {
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    @Override
    public String getDetails() {
        return "Student ID: " + studentId + ", Name: " + getName() + ", Age: " + getAge();
    }
}
