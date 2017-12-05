package com.ul.project.payment;

// TODO: Auto-generated Javadoc
/**
 * The Class PaymentConcept.
 */
public class PaymentConcept {
	
	 /**
 	 * Pay.
 	 *
 	 * @param paymentStrategy the payment strategy
 	 * @return the int
 	 */
 	public int pay(PaymentStrategy paymentStrategy)
	 {
	 int amount = 0;
	int amnt= paymentStrategy.pay(amount);
	 return amnt;
	 }


}
