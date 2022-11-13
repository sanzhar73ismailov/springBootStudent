package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Controller.StudentNotFoundException;
import DAO.StudentDao;
import Model.Student;

@Service
@Transactional
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDao studentdao;

    @Override
    public Student createStudent(Student student) {
        return studentdao.saveStudent(student);
    }

    @Override
    public List<Student> getAll() {
        return studentdao.getStudents();
    }

    @Override
    public void deleteStudent(Long id) {
        if (studentdao.studentNotExist(id)) {
            throw new StudentNotFoundException(id);
        }
        studentdao.deleteStudent(id);
    }

    @Override
    public Student getStudentById(Long id) {
        if (studentdao.studentNotExist(id)) {
            throw new StudentNotFoundException(id);
        }
        return studentdao.getStudentById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        if (studentdao.studentNotExist(student.getStudentId())) {
            throw new StudentNotFoundException(student.getStudentId());
        }
        return studentdao.updateStudent(student);
    }

}
