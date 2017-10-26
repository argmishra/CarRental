package com.ul.project.edit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ul.project.add.AddandDeleteCarService;
import com.ul.project.dto.CarDetail;
import com.ul.project.view.ViewCarService;


public class ShowEditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			e.printStackTrace();
		}

	}


}
