package com.ul.project.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShowCarServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ShowCarServlet");
		String carId=request.getParameter("carId"); 
		System.out.println(carId);
		HttpSession session = request.getSession();
		session.setAttribute("carId", carId);
		RequestDispatcher rd=request.getRequestDispatcher("bookCar.jsp");  
		rd.forward(request,response);
	}

	
}
