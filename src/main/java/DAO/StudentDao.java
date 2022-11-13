package DAO;

import java.util.List;

import Model.Student;

public interface StudentDao {

    Student saveStudent(Student student);

    List<Student> getStudents();

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudent(Long id);

    boolean studentExist(Long id);

    boolean studentNotExist(Long id);
}
