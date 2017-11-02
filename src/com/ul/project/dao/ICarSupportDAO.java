package com.ul.project.dao;

import java.util.ArrayList;

import com.ul.project.dto.BookingDetail;
import com.ul.project.dto.CarDetail;
import com.ul.project.dto.FeedbackDetail;
import com.ul.project.dto.UserDetail;

public interface ICarSupportDAO {

	public void savingFeebdback(FeedbackDetail feedback)throws Exception;
	
	public ArrayList<BookingDetail> gettingBookingHistory() throws Exception;
	
	public ArrayList<UserDetail> gettingAllAvailableUsers() throws Exception;
	
	public ArrayList<FeedbackDetail> gettingAllAvailableFeedbacks() throws Exception;
	
	public ArrayList<CarDetail> gettingAllAvailableCars() throws Exception;
	

}
