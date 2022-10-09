package myproject.dao.abstracts;

import myproject.models.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> getStudents();
    void setStudent(Student student);
}
