package com.ul.project.view.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * The Class ViewAllCarsServlet.
 */
public class ViewAllCarsServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 380431250680609487L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			session.setAttribute("userType", (String) session.getAttribute("userType"));
			ViewCarService viewCarsrvc = new ViewCarService();			
			ArrayList<CarDetail> cdlist = viewCarsrvc.gettingAllAvailableCars();
			session.setAttribute("carlist", cdlist);
			RequestDispatcher rd=request.getRequestDispatcher("viewCars.jsp");  
			rd.forward(request,response);
		}catch (Exception e) {
			CarRentalUtilities.loggingError(e, this.getClass().getSimpleName());
		}

	}

}