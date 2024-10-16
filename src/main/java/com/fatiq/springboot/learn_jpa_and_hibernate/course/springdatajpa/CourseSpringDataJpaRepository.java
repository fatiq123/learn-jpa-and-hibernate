package com.fatiq.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatiq.springboot.learn_jpa_and_hibernate.course.jdbc.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
	
	List<Course> findByAuthor(String name);
	List<Course> findByName(String name);
	
}
