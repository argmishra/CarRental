package com.ul.project.view.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ul.project.dto.CarDetail;
import com.ul.project.utilities.CarRentalUtilities;
import com.ul.project.view.ViewCarService;


// TODO: Auto-generated Javadoc
/**
 * The Class ShowCarServlet.
 */
public class ShowCarServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3937259410537320881L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ViewCarService viewCarsrvc = new ViewCarService();		
			CarDetail cardtl = viewCarsrvc.gettingCarDetail(request.getParameter("carId"));
			request.setAttribute("cardetail",cardtl);
			HttpSession session = request.getSession();
			session.setAttribute("carid", request.getParameter("carId"));
			RequestDispatcher rd=request.getRequestDispatcher("bookCar.jsp");  
			rd.include(request,response);
		}catch (Exception e) {
			CarRentalUtilities.loggingError(e, this.getClass().getSimpleName());
		}


	}
}
