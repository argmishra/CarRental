package com.ul.project.payment;

// TODO: Auto-generated Javadoc
/**
 * The Class CreditCardStrategy.
 */
public class CreditCardStrategy implements PaymentStrategy{
	
	
	/* (non-Javadoc)
	 * @see com.ul.project.payment.PaymentStrategy#pay(int)
	 */
	public int pay(int amnt)
	{
		// As per user's choice
		int result=amnt+100;
		return result;
		
	}
}
