package com.fatiq.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private String INSERT_QUERY = 
			// hard coded
//			"""
//			insert into course (id, name, author)
//			values (2, 'Spring Boot', 'fatiq')
//			""";
			
			// dynamic
			"""
			insert into course (id, name, author)
			values (?,?,?);
			
			""";
	
	private String DELETE_QUERY = 
			"""
			
			delete from course where id = ?
			
			""";
	
	private String SELECT_QUERY = 
			"""
			
			select * from course 
			where id = ?
			
			""";
	
	public void insert(Course course) {
		jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void delete(long id) {
		jdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course select(long id) {
		// REsultSet -> Bean => RowMapper
		
		return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class) ,id);
		
	}
	
}
