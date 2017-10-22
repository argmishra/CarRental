package com.ul.project.add;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ul.project.dao.CarRentalDao;
import com.ul.project.utilities.CarRentalUtilities;


public class BookCarServlet extends HttpServlet {
	
	private static final long serialVersionUID = 3524544790529263118L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CarRentalDao car = new CarRentalDao();
		try {
			car.bookingCar(request.getParameter("bookingCarId"));
			CarRentalUtilities.sendingEmial(car.gettingbookingId(),(String) session.getAttribute("userEmail"),"booking");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("view");  
        rd.forward(request,response);
        
    	

		
	}

}
