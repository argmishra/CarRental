package com.ul.project.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ul.project.constants.CarRentalConstants;
import com.ul.project.dao.CarRentalDao;

public class LoginServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

		String name=request.getParameter("username");  
		String password=request.getParameter("password"); 

	
		CarRentalDao car = new CarRentalDao();
		
			 String userPassword = car.validatingUser(name);
			System.out.println("userPassword" +userPassword);
			 RequestDispatcher rd = null;
			 
			 
		if(userPassword != null && password.trim().equalsIgnoreCase(userPassword.trim()) )	 
		{
			 rd=request.getRequestDispatcher("view");  
	         rd.forward(request,response);
		}
		else {
			request.setAttribute("regmessage",CarRentalConstants.SUCCESFUL_REGISTRATION_MESSAGE);
			request.setAttribute("errorMsg", "Please enter valid credentials!!!!");
			rd=request.getRequestDispatcher("login.jsp");  
	        rd.forward(request,response);
		}
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
