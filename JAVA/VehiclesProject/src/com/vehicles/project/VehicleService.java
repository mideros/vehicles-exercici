package com.vehicles.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class VehicleService {
	
	Scanner lector;	
	List<Wheel> frontWheels;
	List<Wheel> backWheels;
	List<Wheel> bikeWheels ;
	
	Car car1;
	Bike bike1;
	
	public VehicleService() {
		super();
		
		lector = new Scanner(System.in);
		frontWheels = new ArrayList<Wheel>();
		backWheels = new ArrayList<Wheel>();
		bikeWheels = new ArrayList<Wheel>();
	} 	
	
	
	public void addCarro() {
		
		car1=new Car();
		
		String plateC=addPlate();		
		boolean validateC=validatePlate(plateC);
		
		while (!validateC) {
			plateC=addPlate();
			validateC=validatePlate(plateC);
		}
		car1.setPlate(plateC);

		
		String brandC=addBrand();
		boolean validateB=validateText(brandC);
		
		while(!validateB)
		{
			brandC=addBrand();
			validateB=validateText(brandC);
		}
		car1.setBrand(brandC);	
		
		
		String colorC=addColor();
		boolean validarC=validateText(colorC);	
		
		while(!validarC) {
			colorC=addColor();
			validarC=validateText(colorC);
		}
		car1.setColor(colorC);
	
		
		System.out.println("ADD FRONT WHEELS");	
		System.out.println("The two wheels must have the same characteristics");
		for (int i = 0; i < 2; i++) {
			System.out.println("Wheel: " + (i+1));
			frontWheels.add(addWheels());				           
        }
		
		System.out.println("ADDING BACK WHEELS");	
		System.out.println("The two wheels must have the same characteristics");
		for (int j = 0; j < 2; j++) {
			System.out.println("Wheel: " + (j+1));
			backWheels.add(addWheels());				           
        }
		
		try {
				car1.addWheels(frontWheels,backWheels);						
			} 
		catch (Exception e) {
			System.out.println("the wheels must have the same characteristics, try again");
			System.out.println(e.getMessage());						
			}
		
			System.out.println("The car has been registered with the following data:");
			showVehicle(car1);	
	}
	
	public void addBike() {
		
		bike1=new Bike();
		
		String plateC=addPlate();		
		boolean validateC=validatePlate(plateC);
		
		while(!validateC)
		{
			plateC=addPlate();
			validateC=validatePlate(plateC);
		}
		bike1.setPlate(plateC);
		
		
		String brandC=addBrand();
		boolean validateB=validateText(brandC);
		
		while(!validateB) {
			brandC=addBrand();
			validateB=validateText(brandC);
		}
		bike1.setBrand(brandC);

		
		String colorC=addColor();
		boolean validarC=validateText(colorC);
		
		while(!validarC) {
			colorC=addColor();
			validarC=validateText(colorC);
		}
		
		bike1.setColor(colorC);
		
		System.out.println("ADD BIKE WHEELS");
		System.out.println("The two wheels must have the same characteristics");	
		for (int i = 0; i < 2; i++) {
			System.out.println("Wheel: " + (i+1));
			bikeWheels.add(addWheels());				           
        }			
			
		try {
			bike1.addTwoWheelsBike(bikeWheels);						
			} 
		catch (Exception e) {
				System.out.println("the wheels must have the same characteristics, try again");
				System.out.println(e.getMessage());						
			}
		System.out.println("The bike has been registered with the following data:");
		showVehicle(bike1);	
			
	}		

	public String addPlate()
	{
		String plateC="";
		
		System.out.println("Please write the plate:");
		plateC=lector.nextLine().toUpperCase();
		
		return plateC;
	}
	
	public String addBrand()
	{
		String brandC="";
		
		System.out.println("Please write the brand:");
		brandC=lector.nextLine().toUpperCase();
				
		return brandC;
	}
	
	public String addColor()
	{
		String colorC="";
		
		System.out.println("Please write the color:");
		colorC=lector.nextLine().toUpperCase();
				
		return colorC;
	}
	
	
	public boolean validateText(String texto) {
		boolean valido;		
		if(texto.equals("")||texto.length()<=2) {			
			valido=false;
			System.out.println("You must write in a valid format");				
		}else {			
			valido=true;
		}	
		return valido;		
	}	
	
	public boolean validatePlate(String plate) {		
		
		boolean validateM;
		
		if(Pattern.matches("^[0-9]{4}(?!.*(LL|CH))[BCDFGHJKLMNPRSTVWXYZ]{2,3}",plate)==true) 
		{
			validateM=true;
		}else {
			validateM=false;
			System.out.println("The plate does not have a valid format (4 numbers and 3 consonants), enter it again");
		}
		return validateM;		
	}
	
	public Wheel addWheels() {
		
		Wheel wheel= new Wheel();
		String brandWheel="";
		String diameterWheel="";
		double diameter=0;
		boolean validDiameter=false;
		boolean validBrand=false;
		
		while(!validBrand) {
			System.out.println("Please write the wheel mark");
			brandWheel=lector.nextLine().toUpperCase();
			validBrand=validateText(brandWheel);		
		}
		wheel.setBrand(brandWheel);
		
		while (!validDiameter) {			
			System.out.println("Please write the diameter of the wheel");
			diameterWheel=lector.nextLine();
			if((diameterWheel.equals(""))||(Pattern.matches("[a-zA-Z ñÑ]+",diameterWheel) == true))
			{	System.out.println("The diameter does not have a valid format");
				validDiameter=false;
			}else {
				diameter=Double.parseDouble(diameterWheel);
				validDiameter=wheel.validateDiameter(diameter);
			}					
		}
		wheel.setDiameter(diameter);
		return wheel;		
		
	}
	
	public static void showVehicle(Vehicle vehicle) {
		
		List<Wheel> listWheels = new ArrayList<Wheel>();
			
		System.out.println("The plate is: "+ vehicle.getPlate());
		System.out.println("The brand is: "+ vehicle.getBrand());
		System.out.println("The color is: "+ vehicle.getColor()); 			
		
		listWheels=vehicle.getWheels();
		
		System.out.println("WHEELS"); 	
				
		Iterator<Wheel> it = listWheels.iterator();
		while(it.hasNext()){
			Wheel elemento = it.next();
			System.out.println("wheel " + elemento.getBrand()+  " diameter " + elemento.getDiameter());
		}		
	}
}