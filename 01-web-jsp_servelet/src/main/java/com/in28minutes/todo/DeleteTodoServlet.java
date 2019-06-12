 package com.in28minutes.todo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in28minutes.todo.TodoService;
import com.in28minutes.todo.Todo;

@WebServlet(urlPatterns="/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet{
	
	private TodoService todoService = new TodoService();
	
	protected void doGet(HttpServletRequest request, 
			 HttpServletResponse response) throws ServletException, IOException {
		 
		//Deletes the todo item
		todoService.deleteTodo(new Todo(request.getParameter("todo"), request.getParameter("category")));
		//Redirects the request to show the page with the remaining todo items
		response.sendRedirect("/list-todos.do");
	 } 

} 
