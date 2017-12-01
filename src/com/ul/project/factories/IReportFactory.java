package com.ul.project.factories;

import com.itextpdf.text.Document;

interface IReportFactory {

	public void appendingDataForReport(Document document) throws Exception;
}
