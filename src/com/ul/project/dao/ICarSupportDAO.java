package com.ul.project.dao;

import java.util.ArrayList;

import com.ul.project.dto.BookingDetail;
import com.ul.project.dto.CarDetail;
import com.ul.project.dto.FeedbackDetail;
import com.ul.project.dto.UserDetail;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICarSupportDAO.
 */
public interface ICarSupportDAO {

	/**
	 * Saving feebdback.
	 *
	 * @param feedback the feedback
	 * @throws Exception the exception
	 */
	public void savingFeebdback(FeedbackDetail feedback)throws Exception;
	
	/**
	 * Gets the ting booking history.
	 *
	 * @return the ${e.g(1).rsfl()}
	 * @throws Exception the exception
	 */
	public ArrayList<BookingDetail> gettingBookingHistory() throws Exception;
	
	/**
	 * Gets the ting all available users.
	 *
	 * @return the ting all available users
	 * @throws Exception the exception
	 */
	public ArrayList<UserDetail> gettingAllAvailableUsers() throws Exception;
	
	/**
	 * Gets the ting all available feedbacks.
	 *
	 * @return the ting all available feedbacks
	 * @throws Exception the exception
	 */
	public ArrayList<FeedbackDetail> gettingAllAvailableFeedbacks() throws Exception;
	
	/**
	 * Gets the ting all available cars.
	 *
	 * @return the ting all available cars
	 * @throws Exception the void editing car( car detail detail)
	 */
	public ArrayList<CarDetail> gettingAllAvailableCars() throws Exception;
	

}
