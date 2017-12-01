package com.ul.project.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.ul.project.add.AddandDeleteCarService;
import com.ul.project.dao.CarRentalDao;
import com.ul.project.dto.BookingDetail;
import com.ul.project.dto.CarDetail;

public class CarRentalTestCase {

	@Test
	public void addingNewCar() throws Exception {
		AddandDeleteCarService addCar = new AddandDeleteCarService();
		String cname = "BMW";
		String cmodel = "AAA";
		String cseat = "3";
		String cshareType = "NonShareable";
		String carType = "Sports";
		addCar.addingNewCar(cname, cmodel, cseat, cshareType, carType, null);

		CarRentalDao dao = new CarRentalDao();
		int carid = dao.gettingCarId();

		CarDetail detail = dao.gettingCarDetails(Integer.toString(carid));

		assertEquals(cname,detail.getName());
		assertEquals(cmodel,detail.getModel());
		assertEquals(cseat,detail.getSeat());
		assertEquals(cshareType,detail.getShare());
		assertEquals(carType,detail.getCarType());
		assertEquals("UnBooked",detail.getStatus());
	}

	@Test
	public void bookingCar() throws Exception {
		CarRentalDao dao = new CarRentalDao();
		String carid = Integer.toString(dao.gettingCarId());
		dao.gettingCarDetails((carid)).getStatus();
		String presentStatus = dao.gettingCarDetails((carid)).getStatus();
		
		if(presentStatus.equalsIgnoreCase("UnBooked")) {
		BookingDetail bdetail = new BookingDetail();
		bdetail.setPaymentType("Cash");
		dao.bookingCar(carid,bdetail);
		}else {
			dao.updatingCarStatus(dao.gettingCarId());
		}
			
		Assert.assertNotSame(presentStatus,dao.gettingCarDetails((carid)).getStatus());

	}
}
