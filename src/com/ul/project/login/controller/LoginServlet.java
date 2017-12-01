package com.ul.project.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ul.project.login.LoginAndRegistrationService;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginServlet.
 */
public class LoginServlet extends HttpServlet {



	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4853235461621829561L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoginAndRegistrationService user = new LoginAndRegistrationService();
			String userType = user.validatingUser(request.getParameter("username"), request,request.getParameter("password"));
			RequestDispatcher rd= null;
			if(userType.equals("1") || userType.equals("2") || userType.equals("3") || userType.equals("4") ||userType.equals("5") ) {
				request.setAttribute("userType", userType);
				HttpSession session = request.getSession();
				session.setAttribute("userType", userType);
				rd=request.getRequestDispatcher("view");  
				rd.forward(request,response);
			}else {
				request.setAttribute("msg", "Please enter valid credentials!!!!");
				rd=request.getRequestDispatcher("login.jsp");  
				rd.forward(request,response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
