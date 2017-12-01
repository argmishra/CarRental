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
import com.ul.project.dto.FeedbackDetail;
import com.ul.project.utilities.ReportUtilities;

public class FeedbackReport implements IReportFactory {

	/**
	 * Appending data for feedback.
	 *
	 * @param document the document
	 * @throws Exception the exception
	 */
	public void appendingDataForReport(Document document) throws Exception {
		Paragraph subCatPart = new Paragraph();
		subCatPart.add(new Paragraph("Feedbacks History", CarRentalConstants.smallBold));
		ReportUtilities.addEmptyLine(subCatPart, 1);
		
		PdfPTable table = new PdfPTable(2);

		PdfPCell c1 = new PdfPCell(new Phrase("Title"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Description"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		table.setHeaderRows(1);
		CarSupportDAO dao =new CarSupportDAO();
		ArrayList<FeedbackDetail> feedbacklist = null;
		
			feedbacklist = dao.gettingAllAvailableFeedbacks();
		
		for (int i=0 ; i<feedbacklist.size();i++)
		{
			table.addCell(feedbacklist.get(i).getTitle());
			table.addCell(feedbacklist.get(i).getDescription());
			
		}
		
		subCatPart.add(table);
			document.add(subCatPart);

	}
}
