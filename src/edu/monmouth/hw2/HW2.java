package edu.monmouth.hw2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import edu.monmouth.vehicle.*;

public class HW2 {
    private static final int REQUIREDARGS = 3;
    private static final int BADARGS = 1;
    private static final int BADREDIRECT = 2;

    public static void main(String[] args) throws CarException 
    {

        if (args.length != REQUIREDARGS) 
        {
            System.err.println("Usage: HW2 outputFile stringsFile vehiclesFile");
            System.exit(BADARGS);
        }
        try 
        {
            PrintStream redirectStream = new PrintStream(args[0]);
            System.setOut(redirectStream);
            System.setErr(redirectStream);
        } 
        catch (FileNotFoundException e) 
        {
            System.err.println("Cannot redirect output: " + e.getMessage());
            System.exit(BADREDIRECT);
        }
        List<String> strings = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        readStrings(args[1], strings);
        readVehicles(args[2], vehicles);
        System.out.println("\n---Strings list---");
        System.out.println("Is empty: " + strings.isEmpty());
        System.out.println("\nOriginal strings:");
        printStrings(strings);
        if (!strings.isEmpty()) 
        {
            String removedString = strings.remove(0);
            System.out.println("\nRemoved string: " + removedString);
        }
        System.out.println("\nStrings after remove:");
        printStrings(strings);
        strings.add("Added String");
        System.out.println("\nStrings after add:");
        printStrings(strings);
        System.out.println("\n---Strings iterator---");
        Iterator<String> stringIterator = strings.iterator();
        while (stringIterator.hasNext()) 
        {
            System.out.println(stringIterator.next());
        }
        System.out.println("\n---Vehicle list---");
        System.out.println("Is empty: " + vehicles.isEmpty());
        System.out.println("\nOriginal vehicles:");
        printVehicles(vehicles);
        if (!vehicles.isEmpty()) 
        {
            Vehicle removedVehicle = vehicles.remove(0);
            System.out.println("\nRemoved vehicle: " + removedVehicle);
        }
        System.out.println("\nVehicles after remove:");
        printVehicles(vehicles);
        try 
        {
            Vehicle addedVehicle = new Car(PowerTypes.GASOLINE, 10);
            vehicles.add(addedVehicle);
            System.out.println("\nAdded vehicle: " + addedVehicle);
        } 
        catch (CarException e) 
        {
            System.out.println("Could not create test car: " + e.getMessage());
        }
        System.out.println("\nVehicles after add:");
        printVehicles(vehicles);
        System.out.println("\n---Vehicle iterator");
        Iterator<Vehicle> vehicleIterator = vehicles.iterator();
        while (vehicleIterator.hasNext()) 
        {
            System.out.println(vehicleIterator.next());
        }
        if (!vehicles.isEmpty()) 
        {
            Vehicle existingVehicle = vehicles.get(0);
            System.out.println("\n---Contains test---");
            System.out.println("Contains existing vehicle: " + vehicles.contains(existingVehicle));
            try 
            {
                Vehicle missingVehicle = findMissingVehicle(vehicles);
                System.out.println("Contains vehicle not in list: " + vehicles.contains(missingVehicle));
                System.out.println("Test vehicle: " + missingVehicle);
            } 
            catch (Exception e) 
            {
                System.out.println("Could not create a missing test vehicle: " + e.getMessage());
            }
        }
        System.out.println("\nAssignment 2 completed.");
        
        
        
        System.out.println("\nPrinting sizes");
        System.out.println("Strings size: " + strings.size());
        System.out.println("Vehicles Size: " + vehicles.size());
        
        Iterator<String> si = strings.iterator();
        while (si.hasNext()) 
        {
            System.out.println(si.next());
        }
        
        Iterator<Vehicle> vi = vehicles.iterator();
        while (vi.hasNext()) 
        {
            System.out.println(vi.next());
        }
        
        try 
        {
            Vehicle av= new Car(PowerTypes.GASOLINE, 100);
            vehicles.add(av);
            System.out.println("\nAdded vehicle: " + av);
        } 
        catch (CarException e) 
        {
            System.out.println("Could not create test car: " + e.getMessage());
        }
        printVehicles(vehicles);
        vehicles.remove(vehicles.size() - 1);
        
        System.out.println("\nAfter removing vehicle:");
        Iterator<Vehicle> vi2 =vehicles.iterator();
        while (vi2.hasNext()) 
        {
            System.out.println(vi2.next());
        }
    }
    private static void readStrings(String fileName, List<String> strings) 
    {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                strings.add(line);
            }
        } 
        catch (IOException e)
        {
            System.err.println("Error reading strings file: " + e.getMessage());
        }
    }
    private static void readVehicles(String fileName, List<Vehicle> vehicles) 
    {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) 
        {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) 
            {
                lineNumber++;
                String[] fields = line.split(",", -1);
                if (fields.length != 3)
                {
                    System.err.println("Invalid vehicle line " + lineNumber + ": incorrect number of fields: " + line);
                    continue;
                }
                try 
                {
                    String type = fields[0].trim();
                    PowerTypes power = PowerTypes.valueOf( fields[1].trim());
                    int value = Integer.parseInt(fields[2].trim());
                    Vehicle vehicle;
                    if (type.equals("c")) 
                    {
                        vehicle = new Car(power, value);
                    } 
                    else if
                    (type.equals("b")) 
                    {
                        vehicle = new Boat(power, value);
                    } 
                    else if (type.equals("p")) 
                    {
                        vehicle = new Plane(power, value);
                    } 
                    else 
                    {
                        System.err.println("Invalid vehicle type on line "  + lineNumber + ": " + type);
                        continue;
                    }
                    vehicles.add(vehicle);
                } 
                catch (CarException | BoatException | PlaneException | IllegalArgumentException e)
                {
                    System.err.println( "Invalid vehicle on line " + lineNumber + ": " + line );
                    System.err.println(e.getMessage());
                }
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Error reading vehicles file: " + e.getMessage());
        }
    }
    private static void printStrings(List<String> strings) {
        for (String string : strings) 
        {
            System.out.println(string);
        }
    }
    private static void printVehicles(List<Vehicle> vehicles) 
    {
        for (Vehicle vehicle : vehicles) 
        {
            System.out.println(vehicle);
        }
    }
    private static Vehicle findMissingVehicle( List<Vehicle> vehicles) throws Exception 
    {
        for (PowerTypes power : PowerTypes.values()) 
        {
            for (int size = 1; size <= 199; size++) 
            {
                Vehicle candidate = new Car(power, size);
                if (!vehicles.contains(candidate)) {
                    return candidate;
                }
            }
        }
        for (PowerTypes power : PowerTypes.values())
        {
            for (int length = 1; length <= 1300; length++)
            {
                Vehicle candidate = new Boat(power, length);
                if (!vehicles.contains(candidate)) 
                {
                    return candidate;
                }
            }
        }

        throw new Exception("Every possible test vehicle is in the list.");
    }
}