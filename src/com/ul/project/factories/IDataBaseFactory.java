package com.ul.project.factories;

import java.sql.Connection;

interface IDataBaseFactory {
	public Connection getConnection(String dbType) throws Exception;

}
