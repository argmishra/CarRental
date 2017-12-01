package com.ul.project.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ul.project.constants.CarRentalConstants;
import com.ul.project.dao.UserDetailDAO;
import com.ul.project.dto.UserDetail;
import com.ul.project.state.UserContext;
import com.ul.project.state.UserGold;
import com.ul.project.state.UserNormal;
import com.ul.project.state.UserPlatinum;
import com.ul.project.state.UserSilver;
import com.ul.project.state.UserState;
import com.ul.project.utilities.CarRentalUtilities;
import com.ul.project.utilities.TokenEncriptOrDecriptUtility;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginAndRegistrationService.
 */
public class LoginAndRegistrationService {

	/**
	 * Saving user details.
	 *
	 * @param name the name
	 * @param username the username
	 * @param password the password
	 * @param mail the mail
	 * @param number the number
	 * @throws Exception the exception
	 */
	public void savingUserDetails(String name,String username,String password,String mail, String number, String frequency) throws Exception {
		UserDetail userDetail = new UserDetail();
		userDetail.setName(name);
		userDetail.setUsername(username);
		userDetail.setPassword(TokenEncriptOrDecriptUtility.gettingencyptedPassword(password));
		userDetail.setEmail(mail);
		userDetail.setNumber(number);
		userDetail.setFrequency(frequency);
		if(username.equalsIgnoreCase("admin")) {
			userDetail.setUserType(CarRentalConstants.USERTYPE_ADMIN);}else {
				userDetail.setUserType(gettingUserType(frequency));
			}
		UserDetailDAO usrdtl = new UserDetailDAO();
		usrdtl.savingUser(userDetail);
		CarRentalUtilities.sendingEmail(usrdtl.gettingUserId(),mail,"registration");
	}

	private String gettingUserType(String frequency) {
		UserContext context=new UserContext();
		UserState userState = null;
		if(frequency==null) {
			userState = new UserNormal();
		}else if(frequency.equals("1")) {
			userState=  new UserGold();
		}else if(frequency.equals("3")) {
			userState =  new UserPlatinum();
		}else if(frequency.equals("2")) {
			userState =  new UserSilver();
		}else {
			userState = new UserNormal();}
		return userState.gettingUserType(context);
	}


	/**
	 * Validating user.
	 *
	 * @param username the username
	 * @param request the request
	 * @param password the password
	 * @return the int
	 * @throws Exception the exception
	 */
	public String validatingUser( String username,HttpServletRequest request, String password) throws Exception {
		String usertype = CarRentalConstants.USERTYPE_INVALID;
		UserDetail userDetail = new UserDetailDAO().validatingUser(username);
		if(userDetail != null) {
			String ecypassword= TokenEncriptOrDecriptUtility.gettingdecyptedPassword(userDetail.getPassword());
			if(password.equalsIgnoreCase(ecypassword)){
				usertype = userDetail.getUserType();
				if(username.equals("admin")) {
					usertype = CarRentalConstants.USERTYPE_ADMIN;
				}
				HttpSession session = request.getSession();
				session.setAttribute("userEmail", userDetail.getEmail());

			}
		}
		return usertype;
	}

	/**
	 * Changing password.
	 *
	 * @param user the user
	 * @param password the password
	 * @throws Exception the exception
	 */
	public void changingPassword(String user, String password) throws Exception{

		String encytedPassword = TokenEncriptOrDecriptUtility.gettingencyptedPassword(password);
		new UserDetailDAO().changingPassword(user, encytedPassword);
	}
}
