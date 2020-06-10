package com.vehicles.project;

public class Wheel {
	
	private String brand;
	private double diameter;	

	public Wheel() {
		super();
	}

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	

	public boolean equals(Wheel wheel) {
		if ((wheel.getBrand().equals(this.getBrand()))&& (wheel.getDiameter()==this.getDiameter()))
		{
			return true;
		}else {
			return false;
		}	 
	}
	
	public  boolean validateDiameter(double diameter) {
		
		boolean valido;

		if((diameter >= 0.4) && (diameter <= 4.0)){			
			valido=true;
		}else {
			System.out.println("Please enter a valid diameter greater than 0.4 and less than 4");
			valido=false;
		}		
		return valido;
	}	
}