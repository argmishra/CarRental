package com.ul.project.factories;

import com.itextpdf.text.Document;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating IReport objects.
 */
interface IReportFactory {

	/**
	 * Appending data for report.
	 *
	 * @param document the document
	 * @throws Exception the exception
	 */
	public void appendingDataForReport(Document document) throws Exception;
}
