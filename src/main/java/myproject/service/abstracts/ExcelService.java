package myproject.service.abstracts;

import myproject.models.Student;
import myproject.models.User;

import java.util.List;

public interface ExcelService {
    public User loadAllUsers();
    public void unloadAllUsers(List<Student> students);
}
