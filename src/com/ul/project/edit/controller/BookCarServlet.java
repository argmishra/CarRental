package com.ul.project.edit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// TODO: Auto-generated Javadoc
/**
 * The Class BookCarServlet.
 */
public class BookCarServlet extends HttpServlet {

	/** The Edit car servlet. */
	private static final long serialVersionUID = 3524544790529263118L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String paymentType=request.getParameter("paymentType");
            request.setAttribute("paymentType", paymentType);
			RequestDispatcher rd=request.getRequestDispatcher("PaymentType");  
			rd.forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}





	}

}
