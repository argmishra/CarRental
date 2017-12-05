package com.ul.project.payment;

public class PayPalStrategy implements PaymentStrategy{

	/* (non-Javadoc)
	 * @see com.ul.project.payment.PaymentStrategy#pay(int)
	 */
	@Override
	public int pay(int amnt) {
		return 50;
	}

}
