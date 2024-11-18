package com.lucasdota.todolist.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lucasdota.todolist.entities.Todo;
import com.lucasdota.todolist.repositories.TodoRepository;

@Service
public class TodoService {
	private final TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public List<Todo> create(Todo todo) {
		todoRepository.save(todo);
		return list();
	}

	public List<Todo> list() {
		Sort sort = Sort.by("id");
		return todoRepository.findAll(sort);
	}

	public List<Todo> update(Todo todo) {
		todoRepository.save(todo);
		return list();
	}

	public List<Todo> delete(Long id) {
		todoRepository.deleteById(id);
		return list();
	}
}
