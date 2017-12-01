package com.ul.project.factories;

public class ReportCreator {
	public IReportFactory getReportType(String type) throws Exception{	
		if(type.equalsIgnoreCase("1")){
			return new UserDetailReport();
		}else if(type.equalsIgnoreCase("2")){
			return new CarDetailReport();
		}else if(type.equalsIgnoreCase("3")){
			return new BookingDetailReport();
		}else if(type.equalsIgnoreCase("4")){
			return new FeedbackReport();
		}
		return null;
	}
}
