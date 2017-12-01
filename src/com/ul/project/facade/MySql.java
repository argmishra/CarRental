package com.ul.project.facade;

import java.sql.Connection;
import java.sql.DriverManager;

import com.ul.project.constants.CarRentalConstants;

public class MySql implements DatabaseConnections {

	@Override
	public Connection gettingDatabaseConnection() throws Exception {
		Connection connection= null;
		Class.forName("com.mysql.jdbc.Driver");
		 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/carrental",
				CarRentalConstants.DATABASE_USERNAME,CarRentalConstants.DATABASE_PASSWORD);
		 return connection;
		
	}

}
