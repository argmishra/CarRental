package com.ul.project.factories;

import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.ul.project.constants.CarRentalConstants;
import com.ul.project.dao.CarSupportDAO;
import com.ul.project.dto.BookingDetail;
import com.ul.project.utilities.ReportUtilities;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingDetailReport.
 */
public class BookingDetailReport implements IReportFactory {

	/**
	 * Appending data for booking detail.
	 *
	 * @param document the document
	 * @throws Exception the exception
	 */
	public void appendingDataForReport(Document document) throws Exception {
		Paragraph subCatPart = new Paragraph();
		subCatPart.add(new Paragraph("Booking History", CarRentalConstants.smallBold));
		ReportUtilities.addEmptyLine(subCatPart, 1);

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
		ArrayList<BookingDetail> bookinglist = null;

		bookinglist = dao.gettingBookingHistory();


		for (int i=0 ; i<bookinglist.size();i++)
		{
			table.addCell(bookinglist.get(i).getBookingid());
			table.addCell(bookinglist.get(i).getCardid());
			table.addCell(bookinglist.get(i).getPaymentType());
		}

		subCatPart.add(table);
		document.add(subCatPart);
	}


}
