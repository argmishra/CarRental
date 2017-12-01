package com.ul.project.payment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ul.project.threads.ThreadBookCar;

/**
 * Servlet implementation class CashController
 */
public class CashController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CashController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		PaymentConcept pc=new PaymentConcept();
		String price=request.getParameter("cash");
		int cprice=Integer.parseInt(price);
		int amount=	cprice+pc.pay(new PayPalStrategy());
		HttpSession session = request.getSession();
		ThreadBookCar trdbook = new ThreadBookCar((String) session.getAttribute("carid"),request,"cash");
		Thread bookthread = new Thread(trdbook);
		bookthread.start();
		RequestDispatcher rd=request.getRequestDispatcher("paymentChecking.jsp");  
		request.setAttribute("amount", amount);
		rd.forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
