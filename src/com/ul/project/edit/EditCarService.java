package com.ul.project.edit;

import javax.servlet.http.HttpServletRequest;

import com.ul.project.dao.CarRentalDao;
import com.ul.project.dto.BookingDetail;
import com.ul.project.dto.CarDetail;
import com.ul.project.utilities.CarRentalUtilities;

// TODO: Auto-generated Javadoc
/**
 * The Class EditCarService.
 */
public class EditCarService {

	/** The request. */
	private HttpServletRequest request;
	
	/**
	 * Instantiates a new edits the car service.
	 */
	public EditCarService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new edits the car service.
	 *
	 * @param request the request
	 */
	public EditCarService(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * Editing car.
	 *
	 * @param cname the cname
	 * @param cmodel the cmodel
	 * @param cseat the cseat
	 * @param cshareType the cshare type
	 * @param carId the car id
	 * @param cprice the cprice
	 * @throws Exception the exception
	 */
	public void editingCar(String cname,String cmodel,String cseat,String cshareType,String carId,String cprice) throws Exception {
		CarDetail cardetail = new CarDetail();
		cardetail.setModel(cmodel);
		cardetail.setName(cname);
		cardetail.setSeat(cseat);
		cardetail.setId(Integer.parseInt(carId));
		cardetail.setPrice(Integer.parseInt(cprice));
		cardetail.setShare(cshareType);
		cardetail.setStatus("UnBooked");
		CarRentalDao dao = new CarRentalDao();
		dao.editingCar(cardetail);
System.out.println("111111111111");	
	}

	/**
	 * Booking car.
	 *
	 * @param id the id
	 * @param usermail the usermail
	 * @param paymentType the payment type
	 * @throws Exception the exception
	 */
	public synchronized void bookingCar( String id, String usermail, String  paymentType) throws Exception{
		CarRentalDao dao = new CarRentalDao();
		BookingDetail bdetail = new BookingDetail();
		bdetail.setPaymentType(paymentType);
		dao.bookingCar(id,bdetail);
		if(usermail!=null) {
			CarRentalUtilities.sendingEmail(dao.gettingbookingId(),usermail,"booking");
		}


	}
}
