package myproject.service.abstracts;

import myproject.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    void setStudent(Student student);
}
