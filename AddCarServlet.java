package com.ul.project.add;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ul.project.dao.CarRentalDao;
import com.ul.project.utilities.CarRentalUtilities;


public class AddCarServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cname=request.getParameter("cname"); 
		String cmodel=request.getParameter("cmodel"); 
		String cseat=request.getParameter("cseat"); 
		String cprice=request.getParameter("cprice"); 
		String cshareType=request.getParameter("cshareType"); 
		CarRentalDao car = new CarRentalDao();

		HttpSession session = request.getSession();
		
		try {
			car.addingNewCar(cname,cmodel,cseat,cprice,cshareType);
			CarRentalUtilities.sendingEmial(car.gettingCarId(),(String) session.getAttribute("userEmail"),"adding");
			RequestDispatcher rd=request.getRequestDispatcher("view");  
			rd.forward(request,response);

		} catch (Exception e) {e.printStackTrace();}


	}



}
