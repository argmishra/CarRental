package com.ul.project.facade;

import java.sql.Connection;

// TODO: Auto-generated Javadoc
/**
 * The Interface DatabaseConnections.
 */
public interface DatabaseConnections {

	/**
	 * Gets the ting database connection.
	 *
	 * @return the ting database connection
	 * @throws Exception the exception
	 */
	public Connection gettingDatabaseConnection () throws Exception;
}
