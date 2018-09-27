package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user;
		boolean flag=false;
		System.out.println("In sign up servlet");
		String userName=request.getParameter("username");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String comfirmPassword=request.getParameter("confirmpassword");
		String emailID=request.getParameter("emailid");
		long contactInfo=Long.parseLong(request.getParameter("contactinfo"));
		System.out.println(name+userName);
		if((!userName.isEmpty())&&(!password.isEmpty())&&(password.equals(comfirmPassword))&&(!name.isEmpty())) {
			System.out.println("condition satisfied");
			user = new User(userName, name, password, emailID, contactInfo);		
			System.out.println(user);
			Service service=new ServiceImpl();
			flag=service.isUserAdded(user);
			//PrintWriter writer=response.getWriter();
			if(flag) {
				String message="You have successfully signed in. Please login using your username and password.";
				request.setAttribute("mymessage", message);
				RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
			else {
				String message="Something went wrong. Please try again.";
				request.setAttribute("mymessage", message);
				RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				
			}
		}
		else {
			String message="Invalid input. Please try again.";
			request.setAttribute("mymessage", message);
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

}
