package fizo.repos;

import org.springframework.data.repository.CrudRepository;

import fizo.entities.Course;

public interface CourseRepo extends CrudRepository<Course, Integer> {
	
}
