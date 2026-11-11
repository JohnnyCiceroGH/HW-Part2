package edu.monmouth.hw1;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import edu.monmouth.vehicle.*;

public class HW1 {
	public static void main(String[] args) {
		final int REQUIREDARGS=1, BADARGS=1, BADREDIRECT=2;
		
		// check for 1 command line argument
		if(args.length != REQUIREDARGS) {
			System.err.println("Give the name of a log file");
			System.exit(BADARGS);
		}
		// redirect STDOUT & STDERR to file name given in args[0]
		try {
			PrintStream redirectStream = new PrintStream(args[0]);
			System.setOut(redirectStream);
			System.setErr(redirectStream);
		} catch(FileNotFoundException ioe) {
			System.err.println("Cannot redirect stderr and stdout " + ioe.getMessage());
			ioe.printStackTrace();
			System.exit(BADREDIRECT);
		}

		VehicleList vehicleList = new VehicleList();
		
		// verify these methods work on an empty list
		System.out.println("First: " + vehicleList.first());
		System.out.println("Removed first: " + vehicleList.removeFirst());
		System.out.println("Last: " + vehicleList.last());
		System.out.println("Number of Vehicles in list: " + vehicleList.size());
		System.out.println("Is list empty: " + vehicleList.isEmpty());
		System.out.println("Entire list: \n" + vehicleList);
		
		// instantiate Vehicles and insert them into the list
		Vehicle fishingBoat=null, battleShip=null, cruiseShip=null, tesla=null, camaro=null, f350=null, AirPlane=null,FighterPlane=null,SonicPlane=null;

		try {
			fishingBoat=new Boat(PowerTypes.GASOLINE, 12);
			battleShip=new Boat(PowerTypes.FUELOIL, 900);
			cruiseShip=new Boat(PowerTypes.DEISEL, 500);
			tesla=new Car(PowerTypes.ELECTRICITY, 12);
			camaro=new Car(PowerTypes.GASOLINE, 10);
			f350=new Car(PowerTypes.DEISEL, 4);
			AirPlane=new Plane(PowerTypes.GASOLINE, 1000);
			FighterPlane=new Plane(PowerTypes.FUELOIL, 2500);
			SonicPlane=new Plane(PowerTypes.GASOLINE, 1500);
			
		} catch(BoatException be) {
			System.out.println(be.getMessage());
			be.printStackTrace();
		} catch(CarException ce) {
			System.out.println(ce.getMessage());
			ce.printStackTrace();
		} catch (PlaneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// verify constructors generate exception with invalid values
		Vehicle invalidBoat=null, invalidCar=null, invalidPlane=null;
		try {
			invalidBoat = new Boat(PowerTypes.FUELOIL, -8);
		} catch(BoatException be) {
			System.out.println(be.getMessage());
			be.printStackTrace();
		}
		try {
			invalidCar = new Car(PowerTypes.GASOLINE, -4);
		} catch (CarException ce) {
			System.out.println(ce.getMessage());
			ce.printStackTrace();
		}
		try {
			invalidPlane = new Plane(PowerTypes.ELECTRICITY, -1);
		} catch (PlaneException ce) {
			System.out.println(ce.getMessage());
			ce.printStackTrace();
		}
		
		// insert Boat & Car objects into list
		vehicleList.insert(fishingBoat);
		vehicleList.insert(cruiseShip);
		vehicleList.insert(tesla);
		vehicleList.insert(f350);
		vehicleList.insert(AirPlane);
		vehicleList.insert(FighterPlane);
			
		System.out.println("After inserting Vehicles: \n" + vehicleList);
		
		vehicleList.insertEnd(camaro);
		 
		System.out.println("After adding another Vehicle to end: \n" + vehicleList);
		
		System.out.println("First: " + vehicleList.first().toString());
		
		System.out.println("Last: " + vehicleList.last());

		System.out.println("Removed first: " + vehicleList.removeFirst());
		System.out.println("list after removing first: \n" + vehicleList);

		vehicleList.insert(battleShip);
		System.out.println("list after adding another Vehicle: \n" + vehicleList);
		System.out.println("Number of Vehicles in list: " + vehicleList.size());
		System.out.println("Is list empty: " + vehicleList.isEmpty());
		
		vehicleList.insertEnd(SonicPlane);
		System.out.println("After adding another Vehicle to end: \n" + vehicleList);
		System.out.println("Inserted item is: " + vehicleList.last().toString());
		
		
	}
}
