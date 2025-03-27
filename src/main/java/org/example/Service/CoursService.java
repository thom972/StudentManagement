package org.example;

import org.example.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoursService {
    // Liste pour stocker les cours
    private List<Cours> cours = new ArrayList<>();
    private final StudentService studentService;

    // Utiliser l'injection de dépendances via constructeur
    @Autowired
    public CoursService(StudentService studentService) {
        this.studentService = studentService;
    }

    // Créer un nouveau cours
    public Cours createCours(String coursName, int coursCode) {
        if(coursName != null && !coursName.trim().isEmpty() && coursCode > 0) {
            Cours nouveauCours = new Cours(coursName, coursCode);
            this.cours.add(nouveauCours);
            return nouveauCours;
        }
        return null;
    }

    public void add(Cours cours) {
        if (cours != null) {
            boolean coursExists = this.cours.stream()
                    .anyMatch(existingCours -> existingCours.getCoursId() == cours.getCoursId());

            if (!coursExists) {
                this.cours.add(cours);
            }
        }
    }

    // Trouver un cours par son ID
    public Cours findCoursById(int id) {
        return cours.stream()
                .filter(c -> c.getCoursId() == id)
                .findFirst()
                .orElse(null);
    }

    // Obtenir tous les cours
    public List<Cours> getAllCours() {
        return new ArrayList<>(cours);
    }

    // Inscrire un étudiant à un cours
    public boolean enrollStudent(int coursId, int studentId) {
        Cours cours = findCoursById(coursId);
        Student student = studentService.findStudentById(studentId);
        if(cours != null && student != null) {
            cours.enrollStudent(student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(int coursId, int studentId) {
        Cours cours = findCoursById(coursId);
        Student student = studentService.findStudentById(studentId);
        if (cours != null && student != null) {
            cours.removeStudent(student);
            return true;
        }
        return false;
    }
}