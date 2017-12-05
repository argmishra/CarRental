package com.ul.project.car;

// TODO: Auto-generated Javadoc
/**
 * The Class DecoratorPattern.
 */
public class DecoratorPattern 
{
	
	/** The price. */
	int price;
	
	/**
	 * Calc price.
	 *
	 * @param carType the car type
	 * @return the int
	 */
	public int calcPrice(String carType)
	{
	if(carType.equalsIgnoreCase("luxury"))
	{
		ICar car=new LuxuryCar(new BasicCar());
		price=car.calcPrice();
	}
	else if(carType.equalsIgnoreCase("Sports"))
	{
		ICar car=new SportsCar(new BasicCar());
		price=car.calcPrice();
	}
	else if(carType.equalsIgnoreCase("SportsAndLuxury"))
	{
		ICar car=new LuxuryCar(new SportsCar(new BasicCar()));
		price=car.calcPrice();
	}
	
	else
	{
		ICar car=new BasicCar();
		price=car.calcPrice();
	}
	return price;
}
}