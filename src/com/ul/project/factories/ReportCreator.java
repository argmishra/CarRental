package com.ul.project.factories;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportCreator.
 */
public class ReportCreator {
	
	/**
	 * Gets the report type.
	 *
	 * @param type the type
	 * @return the report type
	 * @throws Exception the exception
	 */
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
