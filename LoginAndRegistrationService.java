package com.ul.project.login;

import javax.servlet.http.HttpServletRequest;

import com.ul.project.constants.CarRentalConstants;
import com.ul.project.dao.UserDetailDAO;
import com.ul.project.dto.UserDetail;
import com.ul.project.utilities.CarRentalUtilities;
import com.ul.project.utilities.TokenEncriptOrDecriptUtility;

public class LoginAndRegistrationService {

	public void savingUserDetails(String name,String username,String password,String mail, String number ) throws Exception {
		UserDetail userDetail = new UserDetail();
		userDetail.setName(name);
		userDetail.setUsername(username);
		userDetail.setPassword(TokenEncriptOrDecriptUtility.gettingencyptedPassword(password));
		userDetail.setEmail(mail);
		userDetail.setNumber(number);
		UserDetailDAO usrdtl = new UserDetailDAO();
		usrdtl.savingUser(userDetail);
		CarRentalUtilities.sendingEmail(usrdtl.gettingUserId(),mail,"registration");
	}

	public int validatingUser( String username,HttpServletRequest request, String password) throws Exception {
		int usertype = CarRentalConstants.ID_INVALID;
		String userPassword = new UserDetailDAO().validatingUser(username, request);
		if(userPassword != null) {
			String ecypassword= TokenEncriptOrDecriptUtility.gettingdecyptedPassword(userPassword);
			if(password.equalsIgnoreCase(ecypassword))
			{
				usertype = CarRentalConstants.ID_NORMAL;
				if(username.equalsIgnoreCase("admin")) {
					usertype = CarRentalConstants.ID_ADMIN;
				}
			}
		}
		return usertype;
	}

	public void changingPassword(String user, String password) throws Exception{

		String encytedPassword = TokenEncriptOrDecriptUtility.gettingencyptedPassword(password);
		new UserDetailDAO().changingPassword(user, encytedPassword);
	}
}
