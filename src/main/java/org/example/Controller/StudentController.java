package org.example;
import org.example.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService ;

    public StudentController(StudentService studentService){

        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(
            @RequestParam String name,
            @RequestParam int age
    ) {
        Student createdStudent = studentService.createStudent(name, age);

        if (createdStudent != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentService.findStudentById(id);

        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();

        if (!students.isEmpty()) {
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping("/{id}/grade")
    public ResponseEntity<Void> addGrade(
            @PathVariable int id,
            @RequestParam double grade
    ) {
        boolean gradeAdded = studentService.addGrade(id, grade);

        if (gradeAdded) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/{id}/average")
    public ResponseEntity<Double> getStudentAverage(@PathVariable int id) {
        double average = studentService.getStudentAverage(id);

        if (average >= 0) {
            return ResponseEntity.ok(average);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
