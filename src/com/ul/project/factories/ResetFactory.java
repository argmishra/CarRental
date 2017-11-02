package com.ul.project.factories;

import java.sql.Connection;

import com.ul.project.dao.CarSupportDAO;
import com.ul.project.utilities.DatabaseUtilities;

public class ResetFactory {

	public static void resetting(String rType) throws Exception{
		
		if(rType.equalsIgnoreCase("1")){
			CarSupportDAO.resetBookingStatus();
		}
		
	}
}
