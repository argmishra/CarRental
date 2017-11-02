package com.ul.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ul.project.dto.UserDetail;
import com.ul.project.factories.DataBaseFactory;
import com.ul.project.utilities.TokenEncriptOrDecriptUtility;

public class UserDetailDAO implements IUserDetailDAO{

	@Override
	public void savingUser(UserDetail userdetail) throws Exception {
		Connection connection = DataBaseFactory.getConnection("mysql");
		String insertSql = "INSERT INTO USERDETAIL  (name, username, password, email, number) VALUES (?, ?, ?, ?,?)";
		PreparedStatement preapredStatement = connection.prepareStatement(insertSql);
		preapredStatement.setString(1, userdetail.getName());
		preapredStatement.setString(2, userdetail.getUsername());
		preapredStatement.setString(3, userdetail.getPassword());
		preapredStatement.setString(4, userdetail.getEmail());
		preapredStatement.setString(5, userdetail.getNumber());
		preapredStatement.executeUpdate();


	}

	@Override
	public int gettingUserId() throws Exception {
		int idForUser = 0;
		Connection connection = DataBaseFactory.getConnection("mysql");
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM USERDETAIL ORDER BY id DESC LIMIT 1";
		ResultSet rs = statement.executeQuery(getIdSql);
		while(rs.next()){
			idForUser =  rs.getInt("id");
		}
		return idForUser;
	}

	@Override
	public String validatingUser(String username,HttpServletRequest request) throws Exception {
		Connection connection = DataBaseFactory.getConnection("mysql");
		String passowrd =null;
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM USERDETAIL where username = '"+username+"'";
		ResultSet rs = statement.executeQuery(getIdSql);
		while(rs.next()){
			passowrd =  rs.getString("password");
			HttpSession session = request.getSession();
			session.setAttribute("userEmail", rs.getString("email"));
		}
		
		System.out.println(passowrd);
		return passowrd;
	}

	@Override
	public void changingPassword(String username, String password) throws Exception {
		Connection connection = DataBaseFactory.getConnection("mysql");
		String updateSql = "UPDATE USERDETAIL SET password = '"+password+"' WHERE username = '"+username+"'";
		Statement statement = connection.createStatement();
		statement.executeUpdate(updateSql);
	}

}
