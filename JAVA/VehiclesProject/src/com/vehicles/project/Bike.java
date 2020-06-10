package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {	

	public Bike() {
		super();		
	}

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
	public void addTwoWheelsBike(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2) { 			
			throw new Exception("there are no two wheels to add");
		}
		Wheel frontWheel = wheels.get(0);
		Wheel backWheel = wheels.get(1);

		if (!frontWheel.equals(backWheel)) {
			throw new Exception("the wheels are diferents");	
		}	
		this.wheels.add(frontWheel);
		this.wheels.add(backWheel);
	}
}