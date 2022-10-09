package myproject.webapp.controller.rest;

import myproject.models.Student;
import myproject.service.abstracts.ExcelService;
import myproject.service.abstracts.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students/")
public class StudentRestController {


    private final StudentService studentService;
    private final ExcelService excelService;

    public StudentRestController(StudentService studentService, ExcelService excelService) {
        this.studentService = studentService;
        this.excelService = excelService;
    }

    @PostMapping("/unload")
    public ResponseEntity loadAllUsersToExcelFile() {
        List<Student> students = studentService.getStudents();
        excelService.unloadAllUsers(students);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
