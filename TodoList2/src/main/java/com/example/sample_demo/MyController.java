package com.example.sample_demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import jakarta.validation.Valid;

@Controller
public class MyController {
	@Autowired TodoService todoService;
	
	@GetMapping("/")
	public String showTask(Model model) {
		List <Todo> todos = todoService.getTodo();
		model.addAttribute("todos", todos);
		return "todolist";
	}
	
	@GetMapping("create-page")
	public String createPage(Model model) {
		model.addAttribute("todo", new TodoValidate());
		return "todo_create";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("todo") TodoValidate todo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("todo", todo);
			return "todo_create";
		}
		todoService.addTodo(todo.getTaskName(), todo.getTaskDescription(), todo.getAssignPersonName(), todo.getEstimateHour());
		return "redirect:/";
	}
}
