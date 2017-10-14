package com.ul.project.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ICarRentalDao {
	
	public Connection gettingConnection();
	
	public void savingUser (String name,String username,String password,String email,String number ) throws SQLException;
	
	public int gettingUserId () throws SQLException;

	public String validatingUser (String username) throws SQLException;


}
