package com.ul.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ul.project.constants.CarRentalConstants;

public class CarRentalDao implements ICarRentalDao{

	@Override
	public Connection gettingConnection() {
		Connection connection =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/CARRENTAL","root","root");
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	

	@Override
	public void savingUser(String name,String username,String password,String email,String number) throws SQLException {
		Connection connection = gettingConnection();
		String insertSql = "INSERT INTO USERDETAIL  (name, username, password, email, number) VALUES (?, ?, ?, ?,?)";
		PreparedStatement preapredStatement = connection.prepareStatement(insertSql);
		preapredStatement.setString(1, name);
		preapredStatement.setString(2, username);
		preapredStatement.setString(3, password);
		preapredStatement.setString(4, email);
		preapredStatement.setString(5, number);
		preapredStatement.executeUpdate();
	}

	@Override
	public int gettingUserId() throws SQLException {
		int idForUser = 0;
		Connection connection = gettingConnection();
		Statement statement = connection.createStatement();
		 String getIdSql = "SELECT * FROM USERDETAIL ORDER BY id DESC LIMIT 1";
		 ResultSet rs = statement.executeQuery(getIdSql);
		 while(rs.next()){
			 idForUser =  rs.getInt("id");
		 }
		return idForUser;
	}


	@Override
	public String validatingUser(String username) throws SQLException {
		Connection connection = gettingConnection();
		String passowrd =null;
		Statement statement = connection.createStatement();
		 String getIdSql = "SELECT * FROM USERDETAIL where username = '"+username+"'";
		 ResultSet rs = statement.executeQuery(getIdSql);
		 while(rs.next()){
			 passowrd =  rs.getString("password");
		 }
		return passowrd;
	}

}