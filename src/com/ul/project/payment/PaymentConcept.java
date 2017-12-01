package com.ul.project.payment;

public class PaymentConcept {
	
	

	 public int pay(PaymentStrategy paymentStrategy)
	 {
	 int amount = 0;
	int amnt= paymentStrategy.pay(amount);
	 return amnt;
	 }


}
