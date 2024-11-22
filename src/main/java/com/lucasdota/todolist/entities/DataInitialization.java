package com.lucasdota.todolist.entities;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lucasdota.todolist.services.UserService;

@Configuration
public class DataInitialization {

    @Bean
    public CommandLineRunner initializeData(UserService userService) {
        return args -> {
        	// Create users
        	User user = new User("John Doe", "1234");
        	User user2 = new User("Mark Alloy", "5678");
        	userService.create(user);
        	userService.create(user2);

			// Create to dos
        	Todo todo = new Todo("First Task", "Another initial task");
        	Todo todo2 = new Todo("Second Task", "Another initial task");
        	Todo todo3 = new Todo("Third Task", "Another initial task");
        	Todo todo4 = new Todo("Fourth Task", "Another initial task");
        	userService.createTodoForUser(user, todo);
        	userService.createTodoForUser(user, todo2);
        	userService.createTodoForUser(user2, todo3);
        	userService.createTodoForUser(user2, todo4);

           System.out.println("Initial data setup completed");
        };
    }
}
