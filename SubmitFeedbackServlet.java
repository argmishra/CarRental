package com.ul.project.add;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ul.project.dao.CarRentalDao;


public class SubmitFeedbackServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = -6837125311674498704L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		CarRentalDao car = new CarRentalDao();
		try {
			car.savingFeebdback(request.getParameter("fdTitle"), request.getParameter("fdDescription"));
		} catch (SQLException e) {	}

		request.setAttribute("infoMsg", "Thank you for you feedbaack. You team will get in touch with you soon");
		 RequestDispatcher rd=request.getRequestDispatcher("feedback.jsp");  
        rd.forward(request,response);
	}

	

}
