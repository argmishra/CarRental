package com.ul.project.threads;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ul.project.edit.EditCarService;

public class ThreadBookCar implements Runnable {
	private String carId;
	private HttpServletRequest request;
	private String paymentType;
	
	/**
	 * Instantiates a new thread book car.
	 *
	 * @param carId the car id
	 * @param request the request
	 * @param paymentType the payment type
	 */
	public ThreadBookCar(String carId, HttpServletRequest request, String paymentType) {
		this.carId = carId;
		this.request = request;
		this.paymentType = paymentType;
	}
	@Override
	public void run() {
		EditCarService eserice = new EditCarService(request);
		HttpSession session = request.getSession();
		try {
			eserice.bookingCar(carId,(String)session.getAttribute("userEmail"),paymentType);
		} catch (Exception e) {
			e.printStackTrace();
		}}}

