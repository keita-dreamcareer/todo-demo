package com.example.sample_demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
}
