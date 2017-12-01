package com.ul.project.factories;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.ul.project.constants.CarRentalConstants;
import com.ul.project.utilities.ReportUtilities;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Report objects.
 */
public class ReportFactory{

	/**
	 * Generating report.
	 *
	 * @param rType the r type
	 * @throws Exception the exception
	 */
	public void generatingReport(String rType) throws Exception{
			ReportCreator creator = new ReportCreator();
			IReportFactory  factory= creator.getReportType(rType);
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(CarRentalConstants.REPORT_GENERATION_LOCATION+CarRentalConstants.REPORT_NAME));
			document.open();
			ReportUtilities report = ReportUtilities.getInstance();
			report.addHeaderInfo(document);
			factory.appendingDataForReport(document);
			document.close();
		
	}
}
