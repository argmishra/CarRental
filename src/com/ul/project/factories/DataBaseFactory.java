package com.ul.project.factories;

import java.sql.Connection;

import com.ul.project.facade.DataBaseConnectionExtractor;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating DataBase objects.
 */
public class DataBaseFactory implements IDataBaseFactory {

	private DataBaseFactory() {

	}

	public static DataBaseFactory getInstance() {
		DataBaseFactory	dbfactory = new DataBaseFactory();
		return dbfactory;
	}
	/**
	 * Gets the connection.
	 *
	 * @param dbType the db type
	 * @return the connection
	 * @throws Exception the exception
	 */
	public Connection getConnection(String dbType) throws Exception{
		DataBaseConnectionExtractor dbextractor = DataBaseConnectionExtractor.getInstance();
		Connection connection = dbextractor.gettingDatabaseConnection(dbType);
		return connection;
	}


}
