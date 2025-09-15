package com.org.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.org.dto.Course;



//@FeignClient(name="course-service", url="${course.service.url}")
@FeignClient(name="API-GATEWAY-1")
public interface CourseClient {
	@GetMapping("/courses/{id}")
	public Course getCourse( @PathVariable  Long id);
	
	@PostMapping("/courses/multiple")
	public List<Course> getCousesById(@RequestBody List<Long> ids);

}
