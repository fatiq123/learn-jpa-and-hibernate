package com.fatiq.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fatiq.springboot.learn_jpa_and_hibernate.course.jdbc.Course;
import com.fatiq.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.fatiq.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.fatiq.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

	// Spring JDBC	
	
//	@Autowired
//	private CourseJdbcRepository courseJdbcRepository;
	
//	@Override
//	public void run(String... args) throws Exception {
//		courseJdbcRepository.insert(new Course(1, "Java", "fatiq"));
//		courseJdbcRepository.insert(new Course(2, "Azure", "fatiq"));
//		courseJdbcRepository.insert(new Course(3, "AWS", "fatiq"));
//		courseJdbcRepository.delete(1);
//		
//		System.out.println(courseJdbcRepository.select(1));
//		System.out.println(courseJdbcRepository.select(2));
//	}
	
	
	
	// Spring JPA

//	@Autowired
//	private CourseJpaRepository courseJpaRepository;
//	
//	
//	@Override
//	public void run(String... args) throws Exception {
//		courseJpaRepository.insert(new Course(1, "Java", "fatiq"));
//		courseJpaRepository.insert(new Course(2, "Azure", "fatiq"));
//		courseJpaRepository.insert(new Course(3, "AWS", "fatiq"));
//		
//		courseJpaRepository.deleteById(1);
//		
//		System.out.println(courseJpaRepository.findById(1));
//		System.out.println(courseJpaRepository.findById(2));
//		System.out.println(courseJpaRepository.findById(3));
//		
//		
//	}

	
	// Spring Data Jpa Even more simpler
	
	
	@Autowired
	CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Java", "fatiq"));
		repository.save(new Course(2, "Azure", "fatiq"));
		repository.save(new Course(3, "AWS", "ali"));
		repository.save(new Course(4, "Microservices", "ali"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(1l));
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		
		System.out.println(repository.findByAuthor("fatiq"));
		System.out.println();
		System.out.println(repository.findByAuthor(""));
		System.out.println();
		System.out.println(repository.findByAuthor("ali"));
		System.out.println();
		System.out.println(repository.findByName("Java"));
		System.out.println();
		System.out.println(repository.findByAuthor("Microservices"));
		
	}

}
