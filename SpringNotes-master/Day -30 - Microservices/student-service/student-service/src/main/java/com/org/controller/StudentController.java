package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.config.CourseClient;
import com.org.dto.Course;
import com.org.dto.StudentWithSingleCourse;
import com.org.entity.Student;
import com.org.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentRepository repos;
	
	@Autowired
	private CourseClient webClient;
	
	@PostMapping
	public Student addStudent( @RequestBody Student student)
	{
		return repos.save(student);
	}
	
	@GetMapping("/{id}/course")
	public StudentWithSingleCourse getStudentWithCourse(@PathVariable Long id)
	{
		  Student student=   repos.findById(id).orElse(null);
		  Course course=null;
		  if(student!=null)
		  {
			  course=webClient.getCousesById(student.getCourseId()).get(0);
		  }
		  StudentWithSingleCourse s1=new StudentWithSingleCourse();
		  s1.setName(student.getName());
		  s1.setCourse(course);
		return s1;
	}
	
	
	
	
	
}
