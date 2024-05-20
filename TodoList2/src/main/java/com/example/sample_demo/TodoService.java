package com.example.sample_demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class TodoService {
	@Autowired TodoRepository todoRepository;
	
	/**
	 * todoをすべて取得する
	 * @return list
	 */
	public List<Todo> getTodo(){
		List<Todo> list = todoRepository.findAll();
		return list;
	}
	
	public void addTodo(String task_name, String task_description, String assign_person_name, Double estimate_hour) {
		Todo todo = new Todo(task_name, task_description, assign_person_name, estimate_hour);
		todoRepository.save(todo);
	}
	
	
}
