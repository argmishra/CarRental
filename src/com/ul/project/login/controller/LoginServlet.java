package com.ul.project.login.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.ul.project.login.LoginAndRegistrationService;
import com.ul.project.utilities.ReportUtilities;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 4853235461621829561L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*try {
		System.out.println("Genertae report");
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\anurag\\Downloads\\Projects\\FirstPdf.pdf"));
		document.open();
		ReportUtilities.addHeaderInfo(document);
		document.close();
		}catch (Exception e) {
			// TODO: handle exception
		}*/
		
		try {
			LoginAndRegistrationService user = new LoginAndRegistrationService();
			int userType = user.validatingUser(request.getParameter("username"), request,request.getParameter("password"));
			RequestDispatcher rd= null;
			if(userType == 1 || userType == 2) {
				request.setAttribute("userType", userType);
				rd=request.getRequestDispatcher("view");  
				rd.forward(request,response);
			}else {
				request.setAttribute("msg", "Please enter valid credentials!!!!");
				rd=request.getRequestDispatcher("login.jsp");  
				rd.forward(request,response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
