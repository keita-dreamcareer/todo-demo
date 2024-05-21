package com.example.sample_demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
	List<Todo> findAll();
	List<Todo> deleteById(int id);
	List<Todo> findById(int id);
	
	List<Todo> findByTaskNameContaining(String word);
}
