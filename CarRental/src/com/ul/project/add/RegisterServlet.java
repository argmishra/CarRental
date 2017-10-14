package com.ul.project.add;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ul.project.constants.CarRentalConstants;
import com.ul.project.dao.CarRentalDao;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");  
		String username=request.getParameter("username");  
		String password=request.getParameter("password");  
		String email=request.getParameter("email");  
		String number=request.getParameter("number");  
		
		
		CarRentalDao car = new CarRentalDao();
		try {
			car.savingUser(name,username,password,email,number);
			
			int generatedUSerId = car.gettingUserId();
			System.out.println("generatedUSerId = "+generatedUSerId);
			
			HttpSession session = request.getSession();
			session.setAttribute("regmessage",CarRentalConstants.SUCCESFUL_REGISTRATION_MESSAGE);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
	        rd.include(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	

}
