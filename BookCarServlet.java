package com.ul.project.edit.controller;

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

import com.ul.project.add.AddandDeleteCarService;
import com.ul.project.dao.CarRentalDao;
import com.ul.project.edit.EditCarService;
import com.ul.project.utilities.CarRentalUtilities;
import com.ul.project.utilities.PaymentUtilities;


public class BookCarServlet extends HttpServlet {

	private static final long serialVersionUID = 3524544790529263118L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			EditCarService editCarsrvc = new EditCarService();
			editCarsrvc.bookingCar(request.getParameter("bookingCarId"),request);
			RequestDispatcher rd=request.getRequestDispatcher("paymentChecking.jsp");  
			rd.forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}





	}

}
