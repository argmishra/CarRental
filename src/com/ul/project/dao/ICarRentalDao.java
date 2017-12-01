package com.ul.project.dao;

import java.util.ArrayList;

import com.ul.project.dto.BookingDetail;
import com.ul.project.dto.CarDetail;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICarRentalDao.
 */
public interface ICarRentalDao {
	
	/**
	 * Adding new car.
	 *
	 * @param detail the detail
	 * @throws Exception the exception
	 */
	public void addingNewCar (CarDetail detail) throws Exception;
	
	/**
	 * Gets the ting car id.
	 *
	 * @return the ting car id
	 * @throws Exception the exception
	 */
	public int gettingCarId () throws Exception;
	
	/**
	 * Gets the ting car details.
	 *
	 * @param id the id
	 * @return the ting car details
	 * @throws Exception the exception
	 */
	public CarDetail gettingCarDetails(String id) throws Exception;
	
	/**
	 * Booking car.
	 *
	 * @param id the id
	 * @param detail the detail
	 * @throws Exception the exception
	 */
	public void bookingCar(String id,BookingDetail detail) throws Exception;
	
	/**
	 * Gets the tingbooking id.
	 *
	 * @return the tingbooking id
	 * @throws Exception the exception
	 */
	public int gettingbookingId () throws Exception;
	
	/**
	 * Gets the ting all available cars.
	 *
	 * @return the ting all available cars
	 * @throws Exception the exception
	 */
	public ArrayList<CarDetail> gettingAllAvailableCars() throws Exception;
	
	/**
	 * Editing car.
	 *
	 * @param detail the detail
	 * @throws Exception the exception
	 */
	public void editingCar (CarDetail detail) throws Exception;
	
	/**
	 * Gets the ting car idfrom booking id.
	 *
	 * @param id the id
	 * @return the ting car idfrom booking id
	 * @throws Exception the exception
	 */
	public int gettingCarIdfromBookingId (String id) throws Exception;
	
	/**
	 * Updating car status.
	 *
	 * @param id the id
	 * @throws Exception the exception
	 */
	public void updatingCarStatus (int id) throws Exception;
	

}
