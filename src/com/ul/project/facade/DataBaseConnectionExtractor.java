package com.ul.project.facade;

import java.sql.Connection;

public class DataBaseConnectionExtractor {
	static DataBaseConnectionExtractor dbextractor;
	private MySql mysql;
	private Oracle oracle;
	private DataBaseConnectionExtractor() {
	}

	/**
	 * Gets the single instance of DataBaseConnectionExtractor.
	 *
	 * @return single instance of DataBaseConnectionExtractor
	 * @throws Exception the exception
	 */
	public static DataBaseConnectionExtractor getInstance() throws Exception {
		if(dbextractor==null) {
			dbextractor = new DataBaseConnectionExtractor();}
		return dbextractor;
	}

	public Connection gettingDatabaseConnection(String dbType) throws Exception {

		Connection connection = null;
		if(dbType.equalsIgnoreCase("mysql")) {
			mysql = new MySql();
			connection = mysql.gettingDatabaseConnection();
		}
		if(dbType.equalsIgnoreCase("sql")) {
			oracle =new Oracle();
			connection = oracle.gettingDatabaseConnection();
		}
		return connection;
	}

}
