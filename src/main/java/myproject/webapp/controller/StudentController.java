package myproject.webapp.controller;

import myproject.models.Student;
import myproject.service.abstracts.ExcelService;
import myproject.service.abstracts.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/user")
@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String showInfoOfUser(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "user";
    }

}
