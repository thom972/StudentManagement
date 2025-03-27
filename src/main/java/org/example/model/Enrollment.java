package org.example;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Enrollment {
    private static Long counter = 1L;
    private Long enrollmentId;
    private Student student;
    private Cours cours;
    private boolean active;

    public Enrollment(Student student,Cours cours){
        this.enrollmentId = counter++;
        this.student = student;
        this.cours = cours;
        this.active = true;
    }
    public boolean register(){
        if (student != null && cours != null) {
            cours.enrollStudent(student);
            this.active = true;
            return true;
        }
        return false;
    }
    public boolean unregister() {
        if (student != null && cours != null && active) {
            cours.removeStudent(student);
            this.active = false;
            return true;
        }
        return false;
    }
    public boolean isValid() {
        return student != null && cours != null && active;
    }
}
