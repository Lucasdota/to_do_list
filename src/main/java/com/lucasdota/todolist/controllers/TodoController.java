package com.lucasdota.todolist.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasdota.todolist.entities.Todo;
import com.lucasdota.todolist.services.TodoService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/todos")
public class TodoController {
	private TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        Todo createdTodo = todoService.create(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

	@GetMapping
	List<Todo> list() {	
		return todoService.list();
	}

	@PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable("id") Long id, @RequestBody Todo todo) {
        Optional<Todo> updatedTodo = todoService.update(id, todo);
        return updatedTodo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            todoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
