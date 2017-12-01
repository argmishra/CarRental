package com.ul.project.car;

public  class CarDecorator implements ICar {

	protected ICar car;
	
	public CarDecorator(ICar car){
		this.car=car;
	}
	
	@Override
	public int calcPrice() {
		return this.car.calcPrice();
	}

}
