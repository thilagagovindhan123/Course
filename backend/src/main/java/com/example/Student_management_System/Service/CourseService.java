package com.example.Student_management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Student_management_System.model.Course;
import com.example.Student_management_System.model.CourseRegistry;
import com.example.Student_management_System.repository.CourseRegistryRepo;
import com.example.Student_management_System.repository.CourseRepo;

@Service
public class CourseService {
	@Autowired
	CourseRepo courseRepo;
	@Autowired
	CourseRegistryRepo courseRegistryRepo;
	
	
	@GetMapping("courses")
	public List<Course> availableCourses(){
		return courseRepo.findAll();
	}
	
	
	@GetMapping("courses/enrolled") 
	public List<CourseRegistry> enrolledStudents(){
		return courseRegistryRepo.findAll();
	}
	

    @PostMapping("courses/register")
	public void enrollCourse(String name, String emailId, String courseName) {
		// TODO Auto-generated method stub
		CourseRegistry courseRegistry=new CourseRegistry(name,emailId,courseName);
		courseRegistryRepo.save(courseRegistry);
	}
    @DeleteMapping("courses/delete")
	public void deletebyid(int id) {
		courseRegistryRepo.deleteById(id);
	}

	

}
