package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Student;
import Service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "student service", description = "the student API with description tag annotation")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class Controller {

    @Autowired
    private StudentService studentservice;

    @Operation(summary = "Create new student")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student created successfully", content = @Content(schema = @Schema(implementation = Student.class))),
            @ApiResponse(responseCode = "400", description = "Student parameters not valid"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping("save-student")
    public Student saveStudent(@RequestBody Student student) {
        return studentservice.createStudent(student);

    }

    @GetMapping("students-list")
    public List<Student> allstudents() {
        return studentservice.getAll();
    }

    @DeleteMapping("delete-student/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentservice.deleteStudent(id);
    }

    @GetMapping("student/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentservice.getStudentById(id);
    }

    @PutMapping("update-student/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long id) {
        student.setStudentId(id);
        return studentservice.updateStudent(student);
    }
}
