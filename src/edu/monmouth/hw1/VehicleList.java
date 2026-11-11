package edu.monmouth.hw1;

import edu.monmouth.vehicle.Vehicle;

public class VehicleList 
{
    private VehicleNode head;
    private int count;

    public VehicleList() 
    {
        head = null;
        count = 0;
    }

    public void insert(Vehicle vehicle) 
    {
    	VehicleNode node = new VehicleNode(vehicle);
        node.setNext(head);
        head = node;
        count++;
    }

    public Vehicle first() 
    {
        if (head == null) {
            return null;
        }

        return head.getVehicle();
    }

    public Vehicle last() 
    {
    	if (head == null)
    	   {
    	       return null;
    	   }

    	   VehicleNode current = head;
    	   while (current.getNext() != null)
    	   {
    	       current = current.getNext();
    	   }
    	   return current.getVehicle();
   }

    public Vehicle removeFirst() 
    {
    	if (head == null)
        {
   	        return null;
   	    }
    	Vehicle removed = head.getVehicle();
        head = head.getNext();
   	    count--;

    	return removed;
    }

    public void insertEnd(Vehicle vehicle) 
    {
    VehicleNode node = new VehicleNode(vehicle);
    	 if (head == null)
    	 {
    	     head = node;
    	 }
    	 else
    	 {
    	     VehicleNode current = head;
    	     while (current.getNext() != null)
    	     {
    	         current = current.getNext();
    	     }
    	     current.setNext(node);
    	 }
      count++;
   }

    public boolean isEmpty() 
    {
        return head == null;
    }

    public int size() 
    {
        return count;
    }

    @Override
    public String toString() 
    {
        StringBuilder result = new StringBuilder();
        VehicleNode current = head;

        while (current != null) 
        {
            result.append(current.getVehicle());
            current = current.getNext();

            if (current != null) 
            {
                result.append(System.lineSeparator());
            }
        }

        return result.toString();
    }
}