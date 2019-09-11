package com.yst.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yst.demo.model.Todo;
import com.yst.demo.service.TodoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TodoController {
	private TodoService service;
	@GetMapping
	public List<Todo> getAllTodos() {
		return service.findAll();
	}
}
