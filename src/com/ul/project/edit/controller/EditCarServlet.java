package com.ul.project.edit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ul.project.add.AddandDeleteCarService;
import com.ul.project.edit.EditCarService;


public class EditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			EditCarService editCarsrvc = new EditCarService();
			editCarsrvc.editingCar(request.getParameter("cname"),request.getParameter("cmodel"),request.getParameter("cseat")
					,request.getParameter("cprice"),request.getParameter("cshareType"),request.getParameter("carId"));
			RequestDispatcher rd=request.getRequestDispatcher("view");  
			rd.forward(request,response);

		} catch (Exception e) {e.printStackTrace();}


	}
	

}
