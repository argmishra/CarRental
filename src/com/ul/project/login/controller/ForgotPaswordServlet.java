package com.ul.project.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ul.project.login.LoginAndRegistrationService;
import com.ul.project.utilities.CarRentalUtilities;


// TODO: Auto-generated Javadoc
/**
 * The Class ForgotPaswordServlet.
 */
public class ForgotPaswordServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			LoginAndRegistrationService user = new LoginAndRegistrationService();
			user.changingPassword(request.getParameter("uname"), request.getParameter("npassword"));
			RequestDispatcher rd= null;
			request.setAttribute("msg", "Password resetted succesfully");
			rd=request.getRequestDispatcher("login.jsp");  
			rd.forward(request,response);
		}catch (Exception e) {
			CarRentalUtilities.loggingError(e, this.getClass().getSimpleName());

		}

	}


}
