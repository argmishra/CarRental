package com.ul.project.factories;

import com.ul.project.dao.CarSupportDAO;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Reset objects.
 */
public class ResetFactory {

	/**
	 * Resetting.
	 *
	 * @param rType the r type
	 * @throws Exception the exception
	 */
	public void resetting(String rType) throws Exception{	
		if(rType.equalsIgnoreCase("1")){
			CarSupportDAO.resetBookingStatus();
		}
		
	}
}
