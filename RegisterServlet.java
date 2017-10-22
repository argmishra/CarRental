package com.ul.project.add;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ul.project.constants.CarRentalConstants;
import com.ul.project.dao.CarRentalDao;
import com.ul.project.utilities.CarRentalUtilities;


public class RegisterServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8913558013481663923L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String email=request.getParameter("email");  
		
		CarRentalDao car = new CarRentalDao();
		try {
			car.savingUser(request.getParameter("name"),request.getParameter("username"),request.getParameter("password")
					,email,request.getParameter("number"));			
			CarRentalUtilities.sendingEmial(car.gettingUserId(),email,"registration");
			HttpSession session = request.getSession();
			session.setAttribute("regmessage",CarRentalConstants.SUCCESFUL_REGISTRATION_MESSAGE);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
	        rd.include(request,response);
		} catch (Exception e) {}

		
	}

	

}
