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
        	//User user = new User("Ally Might", "1234");
        	//User user2 = new User("Carlos dos Santos", "5678");
        	//userService.create(user);
        	//userService.create(user2);
			
			// Create todos
        	//Todo todo = new Todo("First Task", "Another initial task");
        	//Todo todo2 = new Todo("Second Task", "Another initial task");
        	//Todo todo3 = new Todo("Third Task", "Another initial task");
        	//Todo todo4 = new Todo("Fourth Task", "Another initial task");
        	//userService.createTodoForUser(user, todo);
        	//userService.createTodoForUser(user, todo2);
        	//userService.createTodoForUser(user2, todo3);
        	//userService.createTodoForUser(user2, todo4);

			// Update todo
			//Todo todo5 = new Todo("Fourth Task", "Another Updated task");
			//userService.updateTodoForUser(7L, 15L, todo5);

			// Update user
			//User user3 = new User("Carlos dos Santos Soares", "5678");
			//userService.update(7L, user3);

			// Delete user
			//userService.delete(6L);

           System.out.println("Initial data setup completed");
        };
    }
}
