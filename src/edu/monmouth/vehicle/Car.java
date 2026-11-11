package edu.monmouth.vehicle;
import java.util.Objects;

public class Car implements Vehicle {

    private int engineSize;
    private PowerTypes powerSource;

    public Car(PowerTypes powerSource, int engineSize) throws CarException {
        setPowerSource(powerSource);
        setEngineSize(engineSize);
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) throws CarException {
        if (engineSize < VehicleConstants.MIN_ENGINE_SIZE
                || engineSize > VehicleConstants.MAX_ENGINE_SIZE) {

            throw new CarException(
                    "Invalid engine size: " + engineSize
                    + ". Engine size must be between "
                    + VehicleConstants.MIN_ENGINE_SIZE
                    + " and "
                    + VehicleConstants.MAX_ENGINE_SIZE + ".");
        }

        this.engineSize = engineSize;
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
    public String toString() {
        return "Car [powerSource=" + powerSource
                + ", engineSize=" + engineSize + "]";
    }
    
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car other = (Car) o;

        return engineSize == other.engineSize
                && powerSource == other.powerSource;
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineSize, powerSource);
    }
}