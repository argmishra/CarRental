package com.ul.project.add.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ul.project.add.AddandDeleteCarService;
import com.ul.project.utilities.CarRentalUtilities;


// TODO: Auto-generated Javadoc
/**
 * The Class DeleteBookingServlet.
 */
public class DeleteBookingServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7092177422500959544L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AddandDeleteCarService carsrvc = new AddandDeleteCarService();
			carsrvc.deletingBooking(request.getParameter("deleteBookingId"),request);
			RequestDispatcher rd=request.getRequestDispatcher("view");  
			rd.forward(request,response);
		}catch (Exception e) {
			CarRentalUtilities.loggingError(e, this.getClass().getSimpleName());
		}
	}


}
