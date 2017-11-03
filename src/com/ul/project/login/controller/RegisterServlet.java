package com.ul.project.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ul.project.constants.CarRentalConstants;
import com.ul.project.login.LoginAndRegistrationService;
// For registration

public class RegisterServlet extends HttpServlet {


	private static final long serialVersionUID = -8913558013481663923L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String email=request.getParameter("email");  
			LoginAndRegistrationService user = new LoginAndRegistrationService();
			user.savingUserDetails(request.getParameter("name"), request.getParameter("username"), request.getParameter("password"),
					email, request.getParameter("number"));
			request.setAttribute("msg", CarRentalConstants.SUCCESFUL_REGISTRATION_MESSAGE);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
			rd.include(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}



}
