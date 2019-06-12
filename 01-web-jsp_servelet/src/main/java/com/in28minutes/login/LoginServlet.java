 package com.in28minutes.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in28minutes.todo.TodoService;
import com.in28minutes.login.LoginService;

@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet{
	
	private LoginService userValidationService = new LoginService();
	private TodoService todoService = new TodoService();
	
	protected void doGet(HttpServletRequest request, 
			 HttpServletResponse response) throws ServletException, IOException {
		 
		 /*
		  //Getting a parameter from the request
		 String name = request.getParameter("name");
		 String password = request.getParameter("password");
		 
		 //Through this servlet, setting the parameter obtained from the url as an attribute 
		 //of the request, that can be used by the JSP
		 request.setAttribute("name", name);
		 request.setAttribute("password", password);
		 */
		 
		 
		 /*
		 * Printing some HTML and non formated stuff directly from the Servlet
		 * 
		 //Initializing the response PrintWriter object
		 PrintWriter out = response.getWriter();
		
		 //Printing some stuff without HTML formating
		 //out.println("Dummy Stuff");
		 //out.println("Dummy Stuff 2");
		 
		 //Print HTML stuff
		 out.println("<html>");
		 out.println("<header>");
		 out.println("<title>Yey</title>");
		 out.println("</header>");
		 out.println("<body>");
		 out.println("Blasfemious maleficari gradum");
		 out.println("</body>");
		 out.println("</html>");
		 */
		
		//Redirecting request to the JSP "login.jsp"
		 request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	 } 

	 protected void doPost(HttpServletRequest request, 
			 HttpServletResponse response) throws ServletException, IOException {
		 		 
		 //Declaring parameters variables
		 String name = request.getParameter("name");
		 String password = request.getParameter("password");
		 
		 boolean isUserValid = userValidationService.isUserValid(name, password);
		  
		 if(isUserValid) {			 
			 /* When this method redirects to todo.do it creates a new request and and all attributes that are part of the first requested 
			 *  that invoked this method will be lost. To solve that, a session scope is created, in other words all attributes are kept
			 *  during the whole session time, rather then only across individual requests. It's done adding the method "getSession()".
			 *  Objects passed on the session will remain alive for the whole time the user session exists, so only strctly necessary
			 *  objects should be passed like that. */
			 request.getSession().setAttribute("name", name);
			 
			 //Redirects user to the Todo Servlet.
			 //This command creates a second request, therefore any scope from the fist request will be lost here.
			 response.sendRedirect("/list-todos.do");
		 }
		 
		 else {
			 request.setAttribute("errorMessage", "Invalid Credentials");
			 request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		 }
	
		 

	 }
}
