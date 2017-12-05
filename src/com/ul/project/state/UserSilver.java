package com.ul.project.state;

import com.ul.project.constants.CarRentalConstants;

public class UserSilver implements UserState {

	/* (non-Javadoc)
	 * @see com.ul.project.state.UserState#gettingUserType(com.ul.project.state.UserContext)
	 */
	@Override
	public String gettingUserType(UserContext context) {
		context.setContextUserType(this);
		return CarRentalConstants.USERTYPE_SILVER;
	}

}
