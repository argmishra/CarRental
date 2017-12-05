package com.ul.project.payment;

public class DebitCardStrategy implements PaymentStrategy{
	
	/* (non-Javadoc)
	 * @see com.ul.project.payment.PaymentStrategy#pay(int)
	 */
	public int pay(int amount)
	{
		// As per user's choice
		int result=amount+500;
		return result;
	}

}
