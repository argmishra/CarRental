package com.ul.project.view;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ul.project.constants.CarRentalConstants;
import com.ul.project.dao.CarRentalDao;
import com.ul.project.dto.CarDetail;


public class ShowCarServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("carId", request.getParameter("carId"));
		CarRentalDao car = new CarRentalDao();
		try {
			CarDetail cardetail = car.gettingCarDetails(request.getParameter("carId"));
			request.setAttribute("cardetail",cardetail);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("bookCar.jsp");  
		rd.include(request,response);
	}

	
}
