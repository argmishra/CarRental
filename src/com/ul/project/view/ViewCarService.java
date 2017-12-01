package com.ul.project.view;

import java.util.ArrayList;

import com.ul.project.dao.CarRentalDao;
import com.ul.project.dto.CarDetail;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewCarService.
 */
public class ViewCarService {

	/**
	 * Gets all available cars.
	 *
	 * @return all available cars
	 * @throws Exception the exception
	 */
	public ArrayList<CarDetail> gettingAllAvailableCars() throws Exception{
		return new CarRentalDao().gettingAllAvailableCars();
	}
	
	/**
	 * Gets the car detail.
	 *
	 * @param id the id
	 * @return car detail
	 * @throws Exception the exception
	 */
	public CarDetail gettingCarDetail( String id) throws Exception{
		return new CarRentalDao().gettingCarDetails(id);
	}
}
