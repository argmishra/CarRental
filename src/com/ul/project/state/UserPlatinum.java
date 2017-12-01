package com.ul.project.state;

import com.ul.project.constants.CarRentalConstants;

public class UserPlatinum implements UserState{

	@Override
	public String gettingUserType(UserContext context) {
		return CarRentalConstants.USERTYPE_PLATINUM;
	}

}
