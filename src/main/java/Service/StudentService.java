package Service;

import java.util.List;

import Model.Student;

public interface StudentService {


    Student createStudent(Student student);

    List<Student> getAll();

    void deleteStudent(Long id);

    Student getStudentById(Long id);

    Student updateStudent(Student student);
}
