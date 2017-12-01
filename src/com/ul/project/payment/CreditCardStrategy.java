package com.ul.project.payment;

public class CreditCardStrategy implements PaymentStrategy{
	
	
	public int pay(int amnt)
	{
		// As per user's choice
		int result=amnt+100;
		return result;
		
	}
}
