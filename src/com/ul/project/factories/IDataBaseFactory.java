package com.ul.project.factories;

import java.sql.Connection;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating IDataBase objects.
 */
interface IDataBaseFactory {
	
	/**
	 * Gets the connection.
	 *
	 * @param dbType the db type
	 * @return the connection
	 * @throws Exception the exception
	 */
	public Connection getConnection(String dbType) throws Exception;

}
