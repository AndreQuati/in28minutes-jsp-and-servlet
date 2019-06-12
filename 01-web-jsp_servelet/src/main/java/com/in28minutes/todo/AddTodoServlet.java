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

@WebServlet(urlPatterns="/add-todo.do")
public class AddTodoServlet extends HttpServlet{
	
	private TodoService todoService = new TodoService();
	
	protected void doGet(HttpServletRequest request, 
			 HttpServletResponse response) throws ServletException, IOException {
		
		//Redirecting request to the JSP "login.jsp"
		 request.getRequestDispatcher("/WEB-INF/views/add-todo.jsp").forward(request, response);
	 } 
	
	protected void doPost(HttpServletRequest request, 
			 HttpServletResponse response) throws ServletException, IOException {
		
		//Adding the input from the user to the Todo list
		String newTodo = request.getParameter("inpTodo"); //Todo's name
		String category = request.getParameter("inpCategory"); //Todo's category 
		todoService.addTodo(new Todo(newTodo, category));
		
		/* Setting the whole Todo list with the new item as attribute of the request, that will display it on the page.
		 * However, in this case, since the action of adding the item to the list and setting the attribute (showing in the page) are
		 * in the same request, every time the page is reloaded a new item will be added, since the reload action will dispatch
		 * this same request.
		 * To fix that, instead of doing the action to display the list directly from here, we'll set a new request to display the item.
		 * */
		 /*
		request.setAttribute("todos", todoService.retrieveTodos()); 
		request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request, response);
		*/
		
		// this redirect the reponse to this Todo.do servlet, which will get it on the doGet method
		response.sendRedirect("/list-todos.do");
	 } 

}
