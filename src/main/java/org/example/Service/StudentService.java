package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();
    //créate Student
    public Student createStudent(String name, int age){
        if (name != null && !name.trim().isEmpty() && age >0) {
            Student student = new Student(name, age);
            students.add(student);
            return student;
        }
        return null;
    }
    // check Student of ID
    public Student findStudentById(int id){
            for (Student student : students) {
                if (student.getStudentId() == id) {
                    return student;
                }
            }

        return null;
    }
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
    public boolean addGrade(int studentId, double grade){
        Student student = findStudentById(studentId);
       
        if(student != null && grade >= 0){
            student.addGrade(grade);
            return true;
        }
        return false;
    }
    public double getStudentAverage(int studentId) {
        Student student = findStudentById(studentId);
        if (student != null) {
            return student.getAverageGrade();
        }
        return 0.0;
    }

}
