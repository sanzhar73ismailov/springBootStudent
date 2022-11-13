package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Student;

@Repository
public class StudentDaoImp implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Student saveStudent(Student student) {
        try {
            Long id = (Long) sessionFactory.getCurrentSession().save(student);
            return getStudentById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getStudents() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Student> query = currentSession.createQuery("from Student", Student.class);
        return query.getResultList();
    }

    @Override
    public void deleteStudent(Long id) {
        try {
            sessionFactory.getCurrentSession().delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Student> query = currentSession.createQuery("from Student where student_id=:id", Student.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public boolean studentExist(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Long> query = currentSession.createQuery("select count(1) from Student where student_id=:id", Long.class);
        query.setParameter("id", id);
        return query.uniqueResult() > 0;
    }

    @Override
    public boolean studentNotExist(Long id) {
        return !studentExist(id);
    }

    @Override
    public Student updateStudent(Student student) {
        try {
            sessionFactory.getCurrentSession().update(student);
            return getStudentById(student.getStudentId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
