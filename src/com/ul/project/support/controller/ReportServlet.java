package com.ul.project.support.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ul.project.constants.CarRentalConstants;
import com.ul.project.factories.ReportFactory;
import com.ul.project.utilities.CarRentalUtilities;


// TODO: Auto-generated Javadoc
/**
 * The Class ReportServlet.
 */
public class ReportServlet extends HttpServlet {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4062831997859823314L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd= null;
			ReportFactory report = new ReportFactory();
			report.generatingReport(request.getParameter("reportId"));
			request.setAttribute("userType", CarRentalConstants.USERTYPE_ADMIN);
			rd=request.getRequestDispatcher("view");  
			rd.forward(request,response);
		} catch (Exception e) {
			CarRentalUtilities.loggingError(e, this.getClass().getSimpleName());
		}
	}


}
