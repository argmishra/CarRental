package com.ul.project.dao;

import com.ul.project.dto.UserDetail;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUserDetailDAO.
 */
public interface IUserDetailDAO {

	/**
	 * Saving user.
	 *
	 * @param userdetail the userdetail
	 * @throws Exception the exception
	 */
	public void savingUser (UserDetail userdetail) throws Exception;
	
	/**
	 * Gets the ting user id.
	 *
	 * @return the ting user id
	 * @throws Exception the exception
	 */
	public int gettingUserId () throws Exception;
	
	/**
	 * Validating user.
	 *
	 * @param username the username
	 * @return the string
	 * @throws Exception the exception
	 */
	public UserDetail validatingUser (String username) throws Exception;
	
	/**
	 * Changing password.
	 *
	 * @param username the username
	 * @param password the password
	 * @throws Exception the exception
	 */
	public void changingPassword (String username,String password) throws Exception;



	
}
