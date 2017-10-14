package com.ul.project.add;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddCarServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cname=request.getParameter("cname"); 
		String cmodel=request.getParameter("cmodel"); 
		String cseat=request.getParameter("cseat"); 
		String cprice=request.getParameter("cprice"); 
		String cshareType=request.getParameter("cshareType"); 

		System.out.println(cname);
		System.out.println(cmodel);
		System.out.println(cseat);
		System.out.println(cprice);
		System.out.println(cshareType);
		try {
		Class.forName("com.mysql.jdbc.Driver");  
		
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/CARRENTAL","root","root");
			
			String sql = "INSERT INTO CARDETAIL (name, model, seat, price,share,status) VALUES (?, ?, ?, ?,?,?)";
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, cname);
			statement.setString(2, cmodel);
			statement.setInt(3, Integer.parseInt(cseat));
			statement.setDouble(4, Double.parseDouble(cprice));
			statement.setString(5, cshareType);
			statement.setString(6, "UnBooked");
			
			statement.executeUpdate();
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
		
		
	}

	

}
