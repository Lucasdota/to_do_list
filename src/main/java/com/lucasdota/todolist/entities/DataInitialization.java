package com.lucasdota.todolist.entities;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lucasdota.todolist.services.TodoService;

@Configuration
public class DataInitialization {

    @Bean
    public CommandLineRunner initializeData(TodoService todoService) {
        return args -> {
            // Create initial tasks
          //  Todo todo1 = new Todo("First Task", "Initial task for system setup");
          //  todoService.create(todo1);

           // Todo todo2 = new Todo("Second Task", "Another initial task");
           // todoService.create(todo2);

		   Todo todo2 = new Todo("Second Task", "Updated task");
			todoService.update(2L, todo2);


           System.out.println("Initial data setup completed");
        };
    }
}
