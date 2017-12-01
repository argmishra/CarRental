package com.ul.project.car;

public class LuxuryCar extends CarDecorator {

	public LuxuryCar(ICar car) {
		super(car);
	}

	public int calcPrice()
	{
		int price=super.calcPrice()+1000;
		return price;
	}

}
