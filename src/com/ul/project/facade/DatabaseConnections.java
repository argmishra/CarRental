package com.ul.project.facade;

import java.sql.Connection;

public interface DatabaseConnections {

	public Connection gettingDatabaseConnection () throws Exception;
}
