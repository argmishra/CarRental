package com.ul.project.factories;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.ul.project.constants.CarRentalConstants;
import com.ul.project.utilities.ReportUtilities;

public class ReportFactory {

	public static void generatingReport(String rType) throws Exception{
		Document document = new Document();
		if(rType.equalsIgnoreCase("1")){
			PdfWriter.getInstance(document, new FileOutputStream(CarRentalConstants.REPORT_GENERATION_LOCATION+CarRentalConstants.REPORT_NAME_USER));
			document.open();
			ReportUtilities.addHeaderInfo(document);
			ReportUtilities.appendingDataForUserDetail(document);
		}else if(rType.equalsIgnoreCase("2")) {
			PdfWriter.getInstance(document, new FileOutputStream(CarRentalConstants.REPORT_GENERATION_LOCATION+CarRentalConstants.REPORT_NAME_CAR));
			document.open();
			ReportUtilities.addHeaderInfo(document);
			ReportUtilities.appendingDataForCarDetail(document);
		}else if(rType.equalsIgnoreCase("3")) {
			PdfWriter.getInstance(document, new FileOutputStream(CarRentalConstants.REPORT_GENERATION_LOCATION+CarRentalConstants.REPORT_NAME_BOOKING));
			document.open();
			ReportUtilities.addHeaderInfo(document);
			ReportUtilities.appendingDataForBookingDetail(document);
		}else if(rType.equalsIgnoreCase("4")) {
			PdfWriter.getInstance(document, new FileOutputStream(CarRentalConstants.REPORT_GENERATION_LOCATION+CarRentalConstants.REPORT_NAME_FEEDBACK));
			document.open();
			ReportUtilities.addHeaderInfo(document);
			ReportUtilities.appendingDataForFeedback(document);
		}

		document.close();
	}
}
