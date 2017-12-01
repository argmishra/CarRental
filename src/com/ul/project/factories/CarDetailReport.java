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
import com.ul.project.dto.CarDetail;
import com.ul.project.utilities.ReportUtilities;

public class CarDetailReport implements IReportFactory {

	/**
	 * Appending data for car detail.
	 *
	 * @param document the document
	 * @throws Exception the exception
	 */
	public void appendingDataForReport(Document document) throws Exception {
		Paragraph subCatPart = new Paragraph();
		subCatPart.add(new Paragraph("Available Car Details ", CarRentalConstants.smallBold));
		ReportUtilities.addEmptyLine(subCatPart, 1);

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
		ArrayList<CarDetail> carList = null;

		carList = dao.gettingAllAvailableCars();

		for (int i=0 ; i<carList.size();i++)
		{
			table.addCell(carList.get(i).getName());
			table.addCell(carList.get(i).getModel());
			table.addCell(carList.get(i).getSeat());
			table.addCell(carList.get(i).getShare());
			table.addCell(carList.get(i).getStatus());
		}

		subCatPart.add(table);
		document.add(subCatPart);

	}



}
