package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.entity.Course;

@RepositoryRestResource(path="courses")
public interface CourseRepository extends JpaRepository<Course, Long>{
	
	/*
	 * default
	 	GET : <Context Path>/courses
		POST : <Context Path>/courses
		DELETE : <Context Path>/courses/{id}
		GET : <Context Path>/courses/{id}
		PUT : <Context Path>/courses/{id}
	 */
	
	// for sorting
	// http://localhost:8005/app-api/courses?sort=title,asc
	
	// disable DELETE
	@RestResource(exported = false)
	void deleteById(Long id);
	
	// disable POST & PUT
	@RestResource(exported = false)
	Course save(Course c);
	  
	  

}
