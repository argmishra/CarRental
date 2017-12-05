package com.ul.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ul.project.dto.UserDetail;
import com.ul.project.factories.DataBaseFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDetailDAO.
 */
public class UserDetailDAO implements IUserDetailDAO{
	
	/** The data base factory. */
	DataBaseFactory dataBaseFactory = DataBaseFactory.getInstance();

	/* (non-Javadoc)
	 * @see com.ul.project.dao.IUserDetailDAO#savingUser(com.ul.project.dto.UserDetail)
	 */
	@Override
	public void savingUser(UserDetail userdetail) throws Exception {
		Connection connection = dataBaseFactory.getConnection("mysql");
		String insertSql = "INSERT INTO USERDETAIL  (name, username, password, email, number, frequency, userType) VALUES (?, ?, ?, ?,?,?,?)";
		PreparedStatement preapredStatement = connection.prepareStatement(insertSql);
		preapredStatement.setString(1, userdetail.getName());
		preapredStatement.setString(2, userdetail.getUsername());
		preapredStatement.setString(3, userdetail.getPassword());
		preapredStatement.setString(4, userdetail.getEmail());
		preapredStatement.setString(5, userdetail.getNumber());
		preapredStatement.setString(6, userdetail.getFrequency());
		preapredStatement.setString(7, userdetail.getUserType());
		preapredStatement.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.ul.project.dao.IUserDetailDAO#gettingUserId()
	 */
	@Override
	public int gettingUserId() throws Exception {
		int idForUser = 0;
		Connection connection = dataBaseFactory.getConnection("mysql");
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM USERDETAIL ORDER BY id DESC LIMIT 1";
		ResultSet rs = statement.executeQuery(getIdSql);
		while(rs.next()){
			idForUser =  rs.getInt("id");
		}
		return idForUser;
	}

	/* (non-Javadoc)
	 * @see com.ul.project.dao.IUserDetailDAO#validatingUser(java.lang.String, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public UserDetail validatingUser(String username) throws Exception {
		Connection connection = dataBaseFactory.getConnection("mysql");
		Statement statement = connection.createStatement();
		String getIdSql = "SELECT * FROM USERDETAIL where username = '"+username+"'";
		ResultSet rs = statement.executeQuery(getIdSql);
		UserDetail userDetail = null;
		while(rs.next()){
			userDetail = new UserDetail();
			userDetail.setPassword(rs.getString("password"));
			userDetail.setUserType(rs.getString("userType"));
			userDetail.setEmail(rs.getString("email"));
		}
		return userDetail;
	}

	/* (non-Javadoc)
	 * @see com.ul.project.dao.IUserDetailDAO#changingPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public void changingPassword(String username, String password) throws Exception {
		Connection connection = dataBaseFactory.getConnection("mysql");
		String updateSql = "UPDATE USERDETAIL SET password = '"+password+"' WHERE username = '"+username+"'";
		Statement statement = connection.createStatement();
		statement.executeUpdate(updateSql);
	}

}
