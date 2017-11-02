package com.ul.project.view.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ul.project.add.AddandDeleteCarService;
import com.ul.project.dto.CarDetail;
import com.ul.project.view.ViewCarService;



public class ViewAllCarsServlet extends HttpServlet {

	private static final long serialVersionUID = 380431250680609487L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ViewCarService viewCarsrvc = new ViewCarService();			
			ArrayList<CarDetail> cdlist = viewCarsrvc.gettingAllAvailableCars();
			HttpSession session = request.getSession();
			session.setAttribute("carlist", cdlist);
			RequestDispatcher rd=request.getRequestDispatcher("viewCars.jsp");  
			rd.forward(request,response);
		}catch (Exception e) {
			e.printStackTrace();		}

	}

}