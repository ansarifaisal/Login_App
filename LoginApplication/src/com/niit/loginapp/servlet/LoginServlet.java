package com.niit.loginapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.loginapp.userdao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CALLING DOGET METHOD");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//read username and password

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html;charset=UTF-8");
		UserDAO userDAO = new UserDAO();
		RequestDispatcher view = null;
		PrintWriter writer = response.getWriter();
		
		if(userDAO.isValidUser(userName, password))
		{
			//need to navigate/dispatch to home page
			//to dispatch the request and response, we need RequestDipatcher which is available on request object
			view = request.getRequestDispatcher("Home.jsp");
		}else{
			//if it is invalid credentials, else part will execute
			//need to navigate to Login page + show Error message
			view = request.getRequestDispatcher("Login.jsp");
			writer.println("Invalid Credentials, Please Try again");
			
			
		}
		view.include(request, response);
	}
}

