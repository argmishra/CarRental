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


public class BookCarServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookingCarId=request.getParameter("bookingCarId"); 
		System.out.println("bookingCarId = "+bookingCarId);
		
		RequestDispatcher rd=request.getRequestDispatcher("view");  
        rd.forward(request,response);
        
    	

		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/CARRENTAL","root","root");
			
			String bookingSql = "INSERT INTO CARBOOKING (carid) VALUES (?)";
			PreparedStatement statement = con.prepareStatement(bookingSql);
			statement.setString(1, bookingCarId);
			statement.executeUpdate();
			
		      String updateSql = "update CARDETAIL set status = ? where id = ?";
		      statement = con.prepareStatement(updateSql);
			
		      statement.setString(1, "Booked");
		      statement.setString(2, bookingCarId);

		      statement.executeUpdate();
			
System.out.println("OKKK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
