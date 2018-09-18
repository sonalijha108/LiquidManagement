package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.User;
import com.services.Service;
import com.services.ServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID =  1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("user");
		String pass=request.getParameter("password");
		if(userName.isEmpty()||pass.isEmpty()) {
			String message="Invalid input. Please try again.";
			request.setAttribute("mymessage", message);
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		else {
		User user=new User();
		Service service=new ServiceImpl();
		user=service.loginUser(userName, pass);
		if(user==null ) {
			String message="You are not a valid user. Please sign in.";
			request.setAttribute("mymessage", message);
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		else
			response.getOutputStream().println("<h1>Hello "+ user.getName()+ "You are logged in." + "!</h1>");
			//RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
			//dispatcher.forward(request, response);
		}
	}

}
