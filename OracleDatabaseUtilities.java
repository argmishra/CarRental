package com.ul.project.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

import com.ul.project.constants.CarRentalConstants;

public class OracleDatabaseUtilities {

	public static Connection gettingOracleConnection() throws Exception {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			   
			Connection connection=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe",CarRentalConstants.ORACLE_USERNAME,CarRentalConstants.ORACLE_PASSWORD);  
			  
			return connection;
	}

}
