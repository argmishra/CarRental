package com.ul.project.dao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.ul.project.dto.UserDetail;

public interface IUserDetailDAO {

	public void savingUser (UserDetail userdetail) throws Exception;
	public int gettingUserId () throws Exception;
	public String validatingUser (String username,HttpServletRequest request) throws Exception;
	public void changingPassword (String username,String password) throws Exception;



	
}
