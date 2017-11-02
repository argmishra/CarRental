package com.ul.project.edit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ul.project.dao.CarRentalDao;
import com.ul.project.dto.BookingDetail;
import com.ul.project.dto.CarDetail;
import com.ul.project.utilities.CarRentalUtilities;
import com.ul.project.utilities.PaymentUtilities;

public class EditCarService {

	public void editingCar(String cname,String cmodel,String cseat,String cprice,String cshareType,String carId) throws Exception {
		CarDetail cardetail = new CarDetail();
		cardetail.setModel(cmodel);
		cardetail.setName(cname);
		cardetail.setSeat(cseat);
		cardetail.setPrice(cprice);
		cardetail.setId(Integer.parseInt(carId));
		if(cshareType == null) {
			cshareType = "Shareable";
		}
		cardetail.setShare(cshareType);
		cardetail.setStatus("UnBooked");
		CarRentalDao dao = new CarRentalDao();
		dao.editingCar(cardetail);	
	}
	
	public void bookingCar( String id,HttpServletRequest request) throws Exception{
		CarRentalDao dao = new CarRentalDao();
		BookingDetail bdetail = new BookingDetail();
		bdetail.setPaymentType(request.getParameter("paymentType"));
		dao.bookingCar(id,bdetail);
		PaymentUtilities.checkingUserInputs(request.getParameter("paymentType"),request.getParameter("cardNumber"),request.getParameter("cardYear"),request.getParameter("cardCVV"));
		HttpSession session = request.getSession();
		CarRentalUtilities.sendingEmail(dao.gettingbookingId(),(String) session.getAttribute("userEmail"),"booking");
	}
}
