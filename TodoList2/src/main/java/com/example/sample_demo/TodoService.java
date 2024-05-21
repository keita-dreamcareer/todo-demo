package com.example.sample_demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class TodoService {
	@Autowired TodoRepository todoRepository;
	
	// Todo全検索
	public List<Todo> searchAll() {
		return todoRepository.findAll();
	}
	
	/**
	 * Todoを追加する
	 * @return
	 */
	public void addTodo(String task_name, String task_description, String assign_person_name, Double estimate_hour) {
		Todo todo = new Todo(task_name, task_description, assign_person_name, estimate_hour);
		todoRepository.save(todo);
	}
	

	// 単体Todoデータ参照
	public List<Todo> findOne(int id) {
        return todoRepository.findById(id);
    }
	
	// Todoデータ更新
	public void editTodo(Todo todo) {
		todoRepository.save(todo);
	}
	
	public void deleteTodo(int id) {
		todoRepository.deleteById(id);
	}
	
	public List<Todo> filterResult(String word){
		return todoRepository.findByTaskNameContaining(word);
	}
	
}
