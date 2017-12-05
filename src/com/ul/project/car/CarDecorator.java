package com.ul.project.car;

// TODO: Auto-generated Javadoc
/**
 * The Class CarDecorator.
 */
public  class CarDecorator implements ICar {

	/** The car. */
	protected ICar car;
	
	/**
	 * Instantiates a new car decorator.
	 *
	 * @param car the car
	 */
	public CarDecorator(ICar car){
		this.car=car;
	}
	
	/* (non-Javadoc)
	 * @see com.ul.project.car.ICar#calcPrice()
	 */
	@Override
	public int calcPrice() {
		return this.car.calcPrice();
	}

}
