package com.ul.project.utilities;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.ul.project.constants.CarRentalConstants;
import com.ul.project.dao.CarRentalDao;
import com.ul.project.dao.CarSupportDAO;
import com.ul.project.dto.BookingDetail;
import com.ul.project.dto.CarDetail;
import com.ul.project.dto.FeedbackDetail;
import com.ul.project.dto.UserDetail;

public class ReportUtilities {

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);

	public static void addHeaderInfo(Document document)throws Exception {
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Car Rental Application ",catFont));
		addEmptyLine(preface, 2);
		preface.add(new Paragraph("Report generated on: "  + new Date(), smallBold));
		addEmptyLine(preface, 1);
		document.add(preface);
		//appendingData(document,preface);
		
	}

	
	public static void appendingDataForBookingDetail(Document document)throws Exception {
		Paragraph subCatPart = new Paragraph();
		subCatPart.add(new Paragraph("Booking History", smallBold));
		addEmptyLine(subCatPart, 1);
		
		PdfPTable table = new PdfPTable(3);

		PdfPCell c1 = new PdfPCell(new Phrase("Booking ID"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Car ID"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Payment Type"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);
		CarSupportDAO dao =new CarSupportDAO();
		ArrayList<BookingDetail> bookinglist = dao.gettingBookingHistory();
		
		for (int i=0 ; i<bookinglist.size();i++)
		{
			table.addCell(bookinglist.get(i).getBookingid());
			table.addCell(bookinglist.get(i).getCardid());
			table.addCell(bookinglist.get(i).getPaymentType());
		}
		
		subCatPart.add(table);
		document.add(subCatPart);

	}
	
	
	public static void appendingDataForCarDetail(Document document)throws Exception {
		Paragraph subCatPart = new Paragraph();
		subCatPart.add(new Paragraph("Available Car Details ", smallBold));
		addEmptyLine(subCatPart, 1);
		
		PdfPTable table = new PdfPTable(6);

		PdfPCell c1 = new PdfPCell(new Phrase("Name"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Model"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Seat"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Price"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Share Choice"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Status"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		
		table.setHeaderRows(1);
		CarSupportDAO dao =new CarSupportDAO();
		ArrayList<CarDetail> carList = dao.gettingAllAvailableCars();
		
		for (int i=0 ; i<carList.size();i++)
		{
			table.addCell(carList.get(i).getName());
			table.addCell(carList.get(i).getModel());
			table.addCell(carList.get(i).getSeat());
			table.addCell(carList.get(i).getPrice());
			table.addCell(carList.get(i).getShare());
			table.addCell(carList.get(i).getStatus());
		}
		
		subCatPart.add(table);
		document.add(subCatPart);

	}
	
	
	public static void appendingDataForUserDetail(Document document)throws Exception {
		Paragraph subCatPart = new Paragraph();
		subCatPart.add(new Paragraph("Available Users Details ", smallBold));
		addEmptyLine(subCatPart, 1);
		
		PdfPTable table = new PdfPTable(4);

		PdfPCell c1 = new PdfPCell(new Phrase("Name"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("User Name"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Email"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Number"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		
		
		table.setHeaderRows(1);
		CarSupportDAO dao =new CarSupportDAO();
		ArrayList<UserDetail> userList = dao.gettingAllAvailableUsers();
		
		for (int i=0 ; i<userList.size();i++)
		{
			table.addCell(userList.get(i).getName());
			table.addCell(userList.get(i).getUsername());
			table.addCell(userList.get(i).getEmail());
			table.addCell(userList.get(i).getNumber());
		}
		
		subCatPart.add(table);
		document.add(subCatPart);

	}

	public static void appendingDataForFeedback(Document document)throws Exception {
		Paragraph subCatPart = new Paragraph();
		subCatPart.add(new Paragraph("Feedbacks History", smallBold));
		addEmptyLine(subCatPart, 1);
		
		PdfPTable table = new PdfPTable(2);

		PdfPCell c1 = new PdfPCell(new Phrase("Title"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Description"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		table.setHeaderRows(1);
		CarSupportDAO dao =new CarSupportDAO();
		ArrayList<FeedbackDetail> feedbacklist = dao.gettingAllAvailableFeedbacks();
		
		for (int i=0 ; i<feedbacklist.size();i++)
		{
			table.addCell(feedbacklist.get(i).getTitle());
			table.addCell(feedbacklist.get(i).getDescription());
			
		}
		
		subCatPart.add(table);
		document.add(subCatPart);

	}
	


	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}



