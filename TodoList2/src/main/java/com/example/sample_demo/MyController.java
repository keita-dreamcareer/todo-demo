package com.example.sample_demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@Controller
@RestController
public class MyController {
	@Autowired TodoService todoService;
	@Autowired TodoRepository todoRepository;
	
	/*
	 * タスク情報一覧画面を表示
	 * 
	 * @return タスク情報一覧画面HTML
	 */
	@GetMapping("/")
	public String showTask(Model model) {
		List <Todo> todos = todoService.searchAll();
		model.addAttribute("todos", todos);
		return "todo_list";
	}
	
	/*
	 * タスク作成画面表示
	 * 
	 * @return タスク作成画面のHTML
	 */
	@GetMapping("create-page")
	public String createPage(Model model) {
		model.addAttribute("todo", new TodoValidate());
		return "todo_create";
	}
	
	/*
	 *  タスク作成
	 *  
	 *  @return タスク情報一覧画面HTML
	 */
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("todo") TodoValidate todo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("todo", todo);
			return "todo_create";
		}
		todoService.addTodo(todo.getTaskName(), todo.getTaskDescription(), todo.getAssignPersonName(), todo.getEstimateHour());
		return "redirect:/";
	}
	
	/*
	 * タスク編集画面表示
	 * 
	 * @return タスク編集画面のHTML
	 */
	
	@GetMapping("/edit-page/{id}")
	public String editTodo(@PathVariable int id, Model model) {
		List<Todo> todo = todoService.findOne(id);
		model.addAttribute("todo", todo.get(0));
		return "todo_edit";
	}
	
	/*
	 * タスク編集
	 * 
	 * @return タスク情報一覧画面HTML
	 */
	@PostMapping("/edit")
	public String edit(@ModelAttribute Todo todo) {
		todoService.editTodo(todo); 
        return "redirect:/";
	}
	
	/*
	 * タスク削除画面表示
	 * 
	 * return タスク削除画面のHTML
	 */
	@GetMapping("delete-page/{id}")
	public String deleteTodo(@PathVariable int id, Model model) {
		List<Todo> todo = todoService.findOne(id);
		model.addAttribute("todo", todo.get(0));
		return "todo_delete";
	}
	
	/*
	 * タスク削除
	 * 
	 * return タスク情報一覧画面HTML
	 */
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		todoService.deleteTodo(id);
		return "redirect:/";
				
	}
	
	/*
	 * タスク検索
	 * 
	 * return タスク情報一覧画面HTML
	 */
	@PostMapping("/filter")
	public String filterTask(@RequestParam String word, Model model) {
		List <Todo> todos = todoService.filterResult(word);
		model.addAttribute("todos", todos);
		return "todo_list";
	}
	
	@GetMapping("/todos")
	public List<Todo> showTodos(Model model) {
		List <Todo> todos = todoService.searchAll();
		return todos;
	}
	
	
	
	
}
