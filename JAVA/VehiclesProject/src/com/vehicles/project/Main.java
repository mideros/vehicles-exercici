package com.vehicles.project;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
				
		Scanner lector = new Scanner(System.in);
		VehicleService service= new VehicleService();
		

			System.out.println("1.Register Car");
			System.out.println("2.Register Bike ");	
			System.out.println("Select an option: ");
			int opcion=lector.nextInt();	
			
			if(opcion==1)
			{
				System.out.println("Register Car");									
				service.addCarro();		
				
			} else if(opcion==2) {
				
				System.out.println("Register Bike");						
				service.addBike();	
			}				
		lector.close();
	}
}
