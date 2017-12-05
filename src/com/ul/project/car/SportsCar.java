package com.ul.project.car;

// TODO: Auto-generated Javadoc
/**
 * The Class SportsCar.
 */
public class SportsCar extends CarDecorator{

	/**
	 * Instantiates a new sports car.
	 *
	 * @param car the car
	 */
	public SportsCar(ICar car) {
		super(car);	}

	/* (non-Javadoc)
	 * @see com.ul.project.car.CarDecorator#calcPrice()
	 */
	public int calcPrice()
	{
		int price=super.calcPrice()+1500;
		return price;
	}
}
