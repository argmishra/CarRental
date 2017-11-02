package com.ul.project.add;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ul.project.dao.CarRentalDao;
import com.ul.project.dto.CarDetail;
import com.ul.project.utilities.CarRentalUtilities;

public class AddandDeleteCarService {

	public void addingNewCar(String cname,String cmodel,String cseat,String cprice,String cshareType,HttpServletRequest request) throws Exception {
		CarDetail cardetail = new CarDetail();
		cardetail.setModel(cmodel);
		cardetail.setName(cname);
		cardetail.setSeat(cseat);
		cardetail.setPrice(cprice);
		if(cshareType == null) {
			cshareType = "Shareable";
		}
		cardetail.setShare(cshareType);
		cardetail.setStatus("UnBooked");
		CarRentalDao dao = new CarRentalDao();
		dao.addingNewCar(cardetail);
		HttpSession session = request.getSession();
		CarRentalUtilities.sendingEmail(dao.gettingCarId(),(String) session.getAttribute("userEmail"),"adding");
	}

	public void deletingBooking(String id,HttpServletRequest request) throws Exception {
		
		CarRentalDao dao = new CarRentalDao();
		int carid = dao.gettingCarIdfromBookingId(id);
		dao.updatingCarStatus(carid);
		HttpSession session = request.getSession();
		CarRentalUtilities.sendingEmail((String) session.getAttribute("userEmail"));
		
	}
	
}
