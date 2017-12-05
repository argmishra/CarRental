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
 * The Class AddCarServlet.
 */
public class AddCarServlet extends HttpServlet  {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;



	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String carType=request.getParameter("ctype");
			AddandDeleteCarService carsrvc = new AddandDeleteCarService();
			carsrvc.addingNewCar(request.getParameter("cname"),request.getParameter("cmodel"),request.getParameter("cseat")
					,request.getParameter("cshareType"),carType,request);
			RequestDispatcher rd=request.getRequestDispatcher("view");  
			rd.forward(request,response);

		} catch (Exception e) {
			CarRentalUtilities.loggingError(e, this.getClass().getSimpleName());

		}


	}





}
