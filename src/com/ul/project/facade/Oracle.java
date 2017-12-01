package com.ul.project.facade;

import java.sql.Connection;
import java.sql.DriverManager;

import com.ul.project.constants.CarRentalConstants;

public class Oracle implements DatabaseConnections{

	@Override
	public Connection gettingDatabaseConnection() throws Exception{
		Connection connection=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		connection=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe",CarRentalConstants.ORACLE_USERNAME,CarRentalConstants.ORACLE_PASSWORD);  
		return connection;
	}
}
