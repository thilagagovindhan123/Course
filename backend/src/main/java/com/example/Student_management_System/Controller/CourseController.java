package com.example.Student_management_System.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Student_management_System.Service.CourseService;
import com.example.Student_management_System.model.Course;
import com.example.Student_management_System.model.CourseRegistry;

@RestController
@CrossOrigin(origins ="http://127.0.0.1:5500")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> availableCourses(){
		return courseService.availableCourses();
	}
	@GetMapping("/courses/enrolled")
	public List<CourseRegistry> enrolledStudents(){
		return courseService.enrolledStudents();
	}
	
	@PostMapping("/courses/register")
	public String enrollCourse(@RequestParam("name") String name, 
			@RequestParam("emailId") String emailId,
			@RequestParam("courseName") String courseName) {
		
		courseService.enrollCourse(name,emailId,courseName);
		return "Congratulation! "+name+" enrollment Successful for "+courseName;
	}
	@DeleteMapping("/{id}")
	public void deletebyid(@PathVariable int id) {
		courseService.deletebyid(id);
	} 
	
	
}
