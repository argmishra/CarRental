package com.ul.project.add;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ul.project.car.DecoratorPattern;
import com.ul.project.dao.CarRentalDao;
import com.ul.project.dto.CarDetail;
import com.ul.project.utilities.CarRentalUtilities;

// TODO: Auto-generated Javadoc
/**
 * The Class AddandDeleteCarService.
 */
public class AddandDeleteCarService {

	/**
	 * Adding new car.
	 *
	 * @param cname the cname
	 * @param cmodel the cmodel
	 * @param cseat the cseat
	 * @param cshareType the cshare type
	 * @param carType the car type
	 * @param request the request
	 * @throws Exception the exception
	 */

	public void addingNewCar(String cname,String cmodel,String cseat,String cshareType,String carType,HttpServletRequest request) throws Exception {
		int cprice=new DecoratorPattern().calcPrice(carType);
		CarDetail cardetail = new CarDetail();
		cardetail.setModel(cmodel);
		cardetail.setName(cname);
		cardetail.setSeat(cseat);
		cardetail.setPrice(cprice);
		cardetail.setCarType(carType);
		cardetail.setShare(cshareType);
		cardetail.setStatus("UnBooked");
		CarRentalDao dao = new CarRentalDao();
		dao.addingNewCar(cardetail);
		if(request!=null) {
		HttpSession session = request.getSession(); 
		CarRentalUtilities.sendingEmail(dao.gettingCarId(),(String) session.getAttribute("userEmail"),"adding");}
	}

	/**
	 * Deleting booking.
	 *
	 * @param id the id
	 * @param request the request
	 * @throws Exception the exception
	 */
	public void deletingBooking(String id,HttpServletRequest request) throws Exception {
		CarRentalDao dao = new CarRentalDao();
		int carid = dao.gettingCarIdfromBookingId(id);
		assert carid >0;
		dao.updatingCarStatus(carid);
		HttpSession session = request.getSession();
		CarRentalUtilities.sendingEmail(0,(String) session.getAttribute("userEmail"),null);

	}

}

