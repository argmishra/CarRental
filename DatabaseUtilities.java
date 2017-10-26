package com.ul.project.utilities;

import java.sql.Connection;
import java.sql.DriverManager;

import com.ul.project.constants.CarRentalConstants;

public class DatabaseUtilities {

	public static Connection gettingMysqlConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/world",
				CarRentalConstants.DATABASE_USERNAME,CarRentalConstants.DATABASE_PASSWORD);
		return connection;
	}
}
