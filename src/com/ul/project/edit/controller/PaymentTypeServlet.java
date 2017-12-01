package com.ul.project.edit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentTypeServlet
 */
public class PaymentTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentTypeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String paymentType=request.getParameter("paymentType");
			if("PayPal".equalsIgnoreCase(paymentType))
			{RequestDispatcher rd=request.getRequestDispatcher("cash.jsp");  
				rd.forward(request,response);
			}else if("Credit".equalsIgnoreCase(paymentType)){
				RequestDispatcher rd=request.getRequestDispatcher("Credit.jsp");  
				rd.forward(request,response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("debit.jsp");  
				rd.forward(request,response);
			}
		}catch (Exception e) {
			e.printStackTrace();		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
