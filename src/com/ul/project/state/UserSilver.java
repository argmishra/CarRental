package com.ul.project.state;

import com.ul.project.constants.CarRentalConstants;

public class UserSilver implements UserState {

	@Override
	public String gettingUserType(UserContext context) {
		// TODO Auto-generated method stub
		return CarRentalConstants.USERTYPE_SILVER;
	}

}
