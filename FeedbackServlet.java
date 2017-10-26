package com.ul.project.support.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ul.project.support.SaveFeedback;


public class FeedbackServlet extends HttpServlet {


	private static final long serialVersionUID = -6837125311674498704L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SaveFeedback savingfb = new SaveFeedback();
			savingfb.savingFeebdback(request.getParameter("fdTitle"), request.getParameter("fdDescription"));
			request.setAttribute("infoMsg", "Thank you for you feedbaack. Our team will get in touch with you soon");
			RequestDispatcher rd=request.getRequestDispatcher("feedback.jsp");  
			rd.forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}


