package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.entity.Course;
import com.org.repository.CourseRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepos;
	
	@PostMapping("/create")
	public Course addCourse(@RequestBody Course course)
	{
	return	courseRepos.save(course);
		
	}
	@GetMapping("/{id}")
	public Course getCourse( @PathVariable  Long id)
	{
		return courseRepos.findById(id).orElse(null);
	}
	
	
	@PostMapping("/multiple")
	public List<Course> getCousesById(@RequestBody List<Long> ids)
	{
		return courseRepos.findAllById(ids);
		
	}

}
