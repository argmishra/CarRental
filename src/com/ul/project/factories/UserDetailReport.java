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
import com.ul.project.dto.UserDetail;
import com.ul.project.utilities.ReportUtilities;

public class UserDetailReport implements IReportFactory {

	/**
	 * Appending data for user detail.
	 *
	 * @param document the document
	 */
	public void appendingDataForReport(Document document) throws Exception{

		Paragraph subCatPart = new Paragraph();
		subCatPart.add(new Paragraph("Available Users Details ", CarRentalConstants.smallBold));
		ReportUtilities.addEmptyLine(subCatPart, 1);

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
		ArrayList<UserDetail> userList = null;

		userList = dao.gettingAllAvailableUsers();

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

}
