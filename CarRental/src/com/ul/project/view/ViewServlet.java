package com.ul.project.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ul.project.dto.CarDetail;



public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In View Servlet");

		

		try {
			Class.forName("com.mysql.jdbc.Driver");  

			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/CARRENTAL","root","root");
			
			 Statement stmt = con.createStatement();
			 
			 String sql = "SELECT * FROM CARDETAIL";
			 ResultSet rs = stmt.executeQuery(sql);
			 ArrayList<CarDetail> cdlist = new ArrayList<CarDetail>();
			 CarDetail carDetail = null;
			 while(rs.next()){
				
				 carDetail = new CarDetail();
		         carDetail.setId(rs.getInt("id"));
		         carDetail.setName(rs.getString("name"));
		         carDetail.setModel(rs.getString("model"));
		         carDetail.setSeat(rs.getInt("seat"));
		         carDetail.setPrice(rs.getInt("price"));
		         carDetail.setShare(rs.getString("share"));
		         carDetail.setStatus(rs.getString("status"));
		         
		         cdlist.add(carDetail);
			 }
			 
			 HttpSession session = request.getSession();
			 session.setAttribute("carlist", cdlist);
			 System.out.println(cdlist.size());
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("viewCars.jsp");  
		rd.forward(request,response);

	}



}
