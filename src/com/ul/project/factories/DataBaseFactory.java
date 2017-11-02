package com.ul.project.factories;

import java.sql.Connection;

import com.ul.project.utilities.DatabaseUtilities;

public class DataBaseFactory {

	public static Connection getConnection(String dbType) throws Exception{
		Connection connection = null;
		if(dbType.equalsIgnoreCase("mysql")){
			connection = DatabaseUtilities.gettingMysqlConnection();
		}
		return connection;
	}
	
	
}
