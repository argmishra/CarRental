package com.ul.project.factories;

import java.sql.Connection;

import com.ul.project.utilities.DatabaseUtilities;
import com.ul.project.utilities.OracleDatabaseUtilities;

public class DataBaseFactory {

	public static Connection getConnection(String dbType) throws Exception{
		Connection connection = null;
		if(dbType.equalsIgnoreCase("mysql")){
			connection = DatabaseUtilities.gettingMysqlConnection();
		}
		else if(dbType.equalsIgnoreCase("oracle"))
		{
			connection=OracleDatabaseUtilities.gettingOracleConnection();
		}
		return connection;
	}
	
	
}
