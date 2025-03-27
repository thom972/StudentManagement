package org.example.controller; // C'est bon

import org.example.Cours; // Changez le chemin d'import
import org.example.CoursService; // Changez le chemin d'import
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CoursController {
    private final CoursService coursService;

    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    // Créer un nouveau cours
    @PostMapping("/create")
    public ResponseEntity<Cours> createCours(
            @RequestParam String coursName,
            @RequestParam int coursCode
    ) {
        Cours createdCours = coursService.createCours(coursName, coursCode);

        if (createdCours != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCours);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Obtenir un cours par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Cours> getCoursById(@PathVariable int id) {
        Cours cours = coursService.findCoursById(id);

        if (cours != null) {
            return ResponseEntity.ok(cours);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Obtenir tous les cours
    @GetMapping("/all")
    public ResponseEntity<List<Cours>> getAllCours() {
        List<Cours> coursList = coursService.getAllCours();

        if (!coursList.isEmpty()) {
            return ResponseEntity.ok(coursList);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    // Inscrire un étudiant à un cours
    @PostMapping("/{coursId}/enroll/{studentId}")
    public ResponseEntity<Void> enrollStudent(
            @PathVariable int coursId,
            @PathVariable int studentId
    ) {
        boolean enrolled = coursService.enrollStudent(coursId, studentId);

        if (enrolled) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Retirer un étudiant d'un cours
    @DeleteMapping("/{coursId}/remove/{studentId}")
    public ResponseEntity<Void> removeStudent(
            @PathVariable int coursId,
            @PathVariable int studentId
    ) {
        boolean removed = coursService.removeStudent(coursId, studentId);

        if (removed) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}