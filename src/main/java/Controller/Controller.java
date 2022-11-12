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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import Model.Student;
import Service.Student_Service;

@Tag(name = "student service", description = "the student API with description tag annotation")
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class Controller {
	
	@Autowired
	private Student_Service studentservice;

	@Operation(summary = "Create new student")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Student created successfully", content = @Content(schema = @Schema(implementation = Student.class))),
			@ApiResponse(responseCode = "400", description = "Student parameters not valid"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@PostMapping("save-student")
	public boolean saveStudent(@RequestBody Student student) {
		 return studentservice.saveStudent(student);
		
	}
	
	@GetMapping("students-list")
	public List<Student> allstudents() {
		 return studentservice.getStudents();
	}
	
	
	@DeleteMapping("delete-student/{student_id}")
	public boolean deleteStudent(@PathVariable("student_id") int student_id,Student student) {
		student.setStudent_id(student_id);
		return studentservice.deleteStudent(student);
	}

	@GetMapping("student/{student_id}")
	public List<Student> allstudentByID(@PathVariable("student_id") int student_id,Student student) {
		 student.setStudent_id(student_id);
		 return studentservice.getStudentByID(student);
		
	}
	
	@PostMapping("update-student/{student_id}")
	public boolean updateStudent(@RequestBody Student student,@PathVariable("student_id") int student_id) {
		student.setStudent_id(student_id);
		return studentservice.updateStudent(student);
	}
}
