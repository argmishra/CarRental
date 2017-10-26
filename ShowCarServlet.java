package com.ul.project.view.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ul.project.add.AddandDeleteCarService;
import com.ul.project.constants.CarRentalConstants;
import com.ul.project.dao.CarRentalDao;
import com.ul.project.dto.CarDetail;
import com.ul.project.view.ViewCarService;


public class ShowCarServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ViewCarService viewCarsrvc = new ViewCarService();		
			CarDetail cardtl = viewCarsrvc.gettingCarDetail(request.getParameter("carId"));
			request.setAttribute("cardetail",cardtl);
			RequestDispatcher rd=request.getRequestDispatcher("bookCar.jsp");  
			rd.include(request,response);
		}catch (Exception e) {
			e.printStackTrace();
		}


	}
}
