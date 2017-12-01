package com.ul.project.state;

import com.ul.project.constants.CarRentalConstants;

public class UserGold implements UserState{


	@Override
	public String gettingUserType(UserContext context) {
		context.setContextUserType(this);
		return CarRentalConstants.USERTYPE_GOLD;
	}

}
