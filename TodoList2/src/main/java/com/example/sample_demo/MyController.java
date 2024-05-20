package com.example.sample_demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@Autowired TodoService todoService;
	
	@GetMapping("/")
	public String showTask(Model model) {
		List <Todo> todos = todoService.getTodo();
		model.addAttribute("todos", todos);
		return "todolist";
	}
}
