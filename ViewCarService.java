package com.ul.project.view;

import java.util.ArrayList;

import com.ul.project.dao.CarRentalDao;
import com.ul.project.dto.CarDetail;

public class ViewCarService {

	public ArrayList<CarDetail> gettingAllAvailableCars() throws Exception{
		return new CarRentalDao().gettingAllAvailableCars();
	}
	
	public CarDetail gettingCarDetail( String id) throws Exception{
		return new CarRentalDao().gettingCarDetails(id);
	}
}
