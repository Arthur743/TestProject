package myproject.dao.impl;

import myproject.dao.abstracts.StudentDao;
import myproject.models.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getStudents() {
        return entityManager.createQuery("SELECT students FROM Student students", Student.class).getResultList();
    }

    @Override
    public void setStudent(Student student) {
        entityManager.persist(student);
    }
}
