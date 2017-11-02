package com.ul.project.dao;

import java.util.ArrayList;

import com.ul.project.dto.BookingDetail;
import com.ul.project.dto.CarDetail;
import com.ul.project.dto.UserDetail;

public interface ICarRentalDao {
	
	public void addingNewCar (CarDetail detail) throws Exception;
	
	public int gettingCarId () throws Exception;
	
	public CarDetail gettingCarDetails(String id) throws Exception;
	
	public void bookingCar(String id,BookingDetail detail) throws Exception;
	
	public int gettingbookingId () throws Exception;
	
	public ArrayList<CarDetail> gettingAllAvailableCars() throws Exception;
	
	public void editingCar (CarDetail detail) throws Exception;
	
	public int gettingCarIdfromBookingId (String id) throws Exception;
	
	public void updatingCarStatus (int id) throws Exception;
	

}
