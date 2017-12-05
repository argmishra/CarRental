package com.ul.project.utilities;

import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.ul.project.constants.CarRentalConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportUtilities.
 */
public class ReportUtilities {

	/** The singleton object. */
	public static ReportUtilities singletonObject;
	
	/**
	 * Instantiates a new report utilities.
	 */
	private ReportUtilities() {}
	 
    /**
     * Gets the single instance of ReportUtilities.
     *
     * @return single instance of ReportUtilities
     */
    public static ReportUtilities getInstance()
    {
    	singletonObject = new ReportUtilities();
        return singletonObject;
    }
	
	/**
	 * Adds the header info.
	 *
	 * @param document the document
	 * @throws Exception the exception
	 */
	public void addHeaderInfo(Document document)throws Exception {
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Car Rental Application ",CarRentalConstants.catFont));
		addEmptyLine(preface, 2);
		preface.add(new Paragraph("Report generated on: "  + new Date(), CarRentalConstants.smallBold));
		addEmptyLine(preface, 1);
		document.add(preface);
		
	}


	/**
	 * Adds the empty line.
	 *
	 * @param paragraph the paragraph
	 * @param number the number
	 * @throws Exception the exception
	 */
	public static void addEmptyLine(Paragraph paragraph, int number) throws Exception{
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}



