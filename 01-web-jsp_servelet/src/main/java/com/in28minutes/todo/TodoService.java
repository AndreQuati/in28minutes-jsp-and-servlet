package com.in28minutes.todo;

import java.util.ArrayList;
import java.util.List;
import com.in28minutes.todo.Todo;

public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	
	static {
		todos.add(new Todo("Learn Web Application Development", "study"));
		todos.add(new Todo("Learn Sprint MVC", "study"));
		todos.add(new Todo("Learn Spring Rest Services", "study"));
	}
	
	public List<Todo> retrieveTodos(){
		return todos;
	}
	
	public void addTodo(Todo todo) {
		todos.add(todo);
	}
	
	public void deleteTodo(Todo todo) {
		todos.remove(todo);
	}

}
