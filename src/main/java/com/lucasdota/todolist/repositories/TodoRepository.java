package com.lucasdota.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasdota.todolist.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
	
}
