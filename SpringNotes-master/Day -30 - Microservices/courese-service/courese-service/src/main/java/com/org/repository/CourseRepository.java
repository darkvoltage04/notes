package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
