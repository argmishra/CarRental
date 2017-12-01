package com.ul.project.car;

public class SportsCar extends CarDecorator{

	public SportsCar(ICar car) {
		super(car);	}

	public int calcPrice()
	{
		int price=super.calcPrice()+1500;
		return price;
	}
}
