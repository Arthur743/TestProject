package myproject.service.imp;

import myproject.models.Student;
import myproject.service.abstracts.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import myproject.dao.abstracts.StudentDao;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }

    @Override
    @Transactional
    public void setStudent(Student student) {
        studentDao.setStudent(student);
    }
}
