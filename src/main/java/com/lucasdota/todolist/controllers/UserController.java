package com.lucasdota.todolist.controllers;

import java.util.List;

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
import com.lucasdota.todolist.entities.User;
import com.lucasdota.todolist.services.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// Create user
	@PostMapping
	public ResponseEntity<User> create(@Valid @RequestBody User user) {
		User createdUser = userService.create(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	// Create a new Todo for a specific user
	public ResponseEntity<Todo> createTodoForUser(@RequestBody User user, @RequestBody Todo todo) {
		try {
			Todo createdTodo = userService.createTodoForUser(user, todo);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	// Get all Todos for a specific User
    @GetMapping("/{id}/todos")
    public ResponseEntity<List<Todo>> getTodosForUser(@PathVariable Long userId) {
        try {
            List<Todo> todos = userService.getTodosForUser(userId);
            return ResponseEntity.ok(todos);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

	// Update a specific Todo for a specific User by userId and todoId
    @PutMapping("/{userId}/todos/{todoId}")
    public ResponseEntity<Todo> updateTodoForUser(@PathVariable Long userId, @PathVariable Long todoId, @RequestBody Todo updatedTodo) {
        try {
            Todo todo = userService.updateTodoForUser(userId, todoId, updatedTodo);
            return ResponseEntity.ok(todo);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

	@DeleteMapping("/{userId}/todos/{todoId}")
	public ResponseEntity<Void> deleteTodoForUser(@PathVariable Long userId, @PathVariable Long todoId) {
		try {
			userService.deleteTodoForUser(userId, todoId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
