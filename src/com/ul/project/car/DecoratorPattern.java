package com.ul.project.car;

public class DecoratorPattern 
{
	int price;
	
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