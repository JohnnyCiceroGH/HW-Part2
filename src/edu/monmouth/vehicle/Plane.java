package edu.monmouth.vehicle;

public class Plane implements Vehicle{
	  private int planeLength;
	    private PowerTypes powerSource;

	    public Plane(PowerTypes powerSource, int planeLength) throws PlaneException {
	        setPowerSource(powerSource);
	        setPlaneLength(planeLength);
	    }

	    public int getBoatLength() {
	        return planeLength;
	    }

	    public void setPlaneLength(int planeLength) throws PlaneException {
	        if (planeLength< VehicleConstants.MIN_PLANE_LENGTH
	                || planeLength > VehicleConstants.MAX_PLANE_LENGTH) {

	            throw new PlaneException(
	                    "Invalid boat length: " + planeLength
	                    + ". Plane length must be between "
	                    + VehicleConstants.MIN_PLANE_LENGTH
	                    + " and "
	                    + VehicleConstants.MAX_PLANE_LENGTH + ".");
	        }

	        this.planeLength = planeLength;
	    }

	    @Override
	    public void go() {
	    }

	    @Override
	    public void stop() {
	    }

	    @Override
	    public PowerTypes powerBy() {
	        return powerSource;
	    }

	    public void setPowerSource(PowerTypes powerSource) {
	        this.powerSource = powerSource;
	    }

	    public PowerTypes getPowerSource() {
	        return powerSource;
	    }
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) {
	            return true;
	        }

	        if (o == null || getClass() != o.getClass()) {
	            return false;
	        }

	        Plane other = (Plane) o;

	        return planeLength == other.planeLength
	                && powerSource == other.powerSource;
	    }
	    @Override
	    public String toString() {
	        return "Plane [powerSource=" + powerSource
	                + ", boatLength=" + planeLength + "]";
}
}
