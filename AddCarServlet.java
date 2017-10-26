package com.ul.project.add.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ul.project.add.AddandDeleteCarService;
import com.ul.project.dao.CarRentalDao;
import com.ul.project.login.LoginAndRegistrationService;
import com.ul.project.utilities.CarRentalUtilities;


public class AddCarServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AddandDeleteCarService carsrvc = new AddandDeleteCarService();
			carsrvc.addingNewCar(request.getParameter("cname"),request.getParameter("cmodel"),request.getParameter("cseat")
					,request.getParameter("cprice"),request.getParameter("cshareType"),request);
			RequestDispatcher rd=request.getRequestDispatcher("view");  
			rd.forward(request,response);

		} catch (Exception e) {e.printStackTrace();}


	}



}
