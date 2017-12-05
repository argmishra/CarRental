package com.ul.project.edit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ul.project.dto.CarDetail;
import com.ul.project.utilities.CarRentalUtilities;
import com.ul.project.view.ViewCarService;


// TODO: Auto-generated Javadoc
/**
 * The Class ShowEditCarServlet.
 */
public class ShowEditCarServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ViewCarService viewCarsrvc = new ViewCarService();
			CarDetail cardtl = viewCarsrvc.gettingCarDetail(request.getParameter("carId"));
			if(cardtl == null) {
				request.setAttribute("msg", "Car Not Found");
				RequestDispatcher rd=request.getRequestDispatcher("viewCars.jsp");  
				rd.forward(request,response);
			} else {
				request.setAttribute("cardtl",cardtl);
				RequestDispatcher rd=request.getRequestDispatcher("editCar.jsp"); 
				rd.forward(request,response);

			}
		}catch (Exception e) {
			CarRentalUtilities.loggingError(e, this.getClass().getSimpleName());

		}

	}


}
